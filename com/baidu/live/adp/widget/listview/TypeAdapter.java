package com.baidu.live.adp.widget.listview;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class TypeAdapter extends BaseAdapter implements ITypeListAdapter<IAdapterData> {
    private static final int INVAILD_ITEM_VIEW_TYPE = -1;
    public static final int INVAILD_POSITION = -1;
    private SparseArray<AbsDelegateAdapter<IAdapterData, ViewHolder>> mDelegateAdapters;
    @SuppressLint({"UseSparseArrays"})
    private SparseArray<Integer> mViewTypes = new SparseArray<>();
    private List<IAdapterData> mLists = new ArrayList();

    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
    public int getCount() {
        if (this.mLists != null) {
            return this.mLists.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
    public IAdapterData getItem(int i) {
        if (this.mLists != null) {
            int size = this.mLists.size();
            if (i >= 0 && i < size) {
                return this.mLists.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter, com.baidu.live.adp.widget.listview.IListAdapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AbsDelegateAdapter<IAdapterData, ViewHolder> absDelegateAdapter;
        View view2 = null;
        if (this.mDelegateAdapters != null && this.mLists != null) {
            int count = getCount();
            if (i >= 0 && i < count && (absDelegateAdapter = this.mDelegateAdapters.get(getItemViewType(i))) != null) {
                IAdapterData item = getItem(i);
                if (item != null && (item instanceof IAdapterData)) {
                    view2 = absDelegateAdapter.getView(i, view, viewGroup, item);
                }
                if (view2 == null) {
                    Log.e("BdTypeListView", absDelegateAdapter.getClass().getName());
                }
                return view2;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        IAdapterData item;
        BdUniqueId type;
        Integer num;
        if (this.mDelegateAdapters == null || this.mDelegateAdapters.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.mViewTypes.get(type.getId())) == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mDelegateAdapters != null) {
            return this.mDelegateAdapters.size();
        }
        return 0;
    }

    public void addAdapter(AbsDelegateAdapter<IAdapterData, ViewHolder> absDelegateAdapter) {
        if (absDelegateAdapter != null && absDelegateAdapter.getType() != null) {
            if (this.mDelegateAdapters == null) {
                this.mDelegateAdapters = new SparseArray<>();
            }
            if (absDelegateAdapter.getType() != null) {
                absDelegateAdapter.setAdapter(this);
                int id = absDelegateAdapter.getType().getId();
                int size = this.mDelegateAdapters.size();
                this.mDelegateAdapters.put(size, absDelegateAdapter);
                this.mViewTypes.put(id, Integer.valueOf(size));
            }
        }
    }

    public void setData(List<? extends IAdapterData> list) {
        if (this.mLists == null) {
            this.mLists = new ArrayList();
        } else {
            this.mLists.clear();
        }
        this.mLists.addAll(list);
        notifyDataSetChanged();
    }

    public List<IAdapterData> getData() {
        return this.mLists;
    }

    public IAdapterData getItemByType(int i, int i2) {
        if (this.mLists == null || this.mLists.size() == 0) {
            return null;
        }
        int i3 = 0;
        Iterator<IAdapterData> it = this.mLists.iterator();
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return null;
            }
            IAdapterData next = it.next();
            if (next != null && next.getType() != null && next.getType().getId() == i2) {
                if (i4 != i) {
                    i4++;
                } else {
                    return next;
                }
            }
            i3 = i4;
        }
    }

    public IAdapterData getItemByBdUniqueId(int i, BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return null;
        }
        return getItemByType(i, bdUniqueId.getId());
    }

    public int getCountByType(int i) {
        int i2 = 0;
        Iterator<IAdapterData> it = this.mLists.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                IAdapterData next = it.next();
                if (next != null && next.getType() != null && next.getType().getId() == i) {
                    i3++;
                }
                i2 = i3;
            } else {
                return i3;
            }
        }
    }

    public int getCountByBdUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return 0;
        }
        return getCountByType(bdUniqueId.getId());
    }

    public void onItemClick(ViewGroup viewGroup, View view, int i, long j) {
        AbsDelegateAdapter<IAdapterData, ViewHolder> absDelegateAdapter;
        if (this.mDelegateAdapters != null) {
            IAdapterData item = getItem(i);
            int itemViewType = getItemViewType(i);
            if (itemViewType < 0) {
                absDelegateAdapter = null;
            } else {
                absDelegateAdapter = this.mDelegateAdapters.valueAt(itemViewType);
            }
            if (absDelegateAdapter != null && absDelegateAdapter.getOnAdapterItemClickListener() != null) {
                absDelegateAdapter.getOnAdapterItemClickListener().onItemClick(view, item, absDelegateAdapter.getType(), viewGroup, i, j);
            }
        }
    }

    public boolean onItemLongClick(ViewGroup viewGroup, View view, int i, long j) {
        AbsDelegateAdapter<IAdapterData, ViewHolder> absDelegateAdapter;
        if (this.mDelegateAdapters == null) {
            return false;
        }
        IAdapterData item = getItem(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType < 0) {
            absDelegateAdapter = null;
        } else {
            absDelegateAdapter = this.mDelegateAdapters.valueAt(itemViewType);
        }
        if (absDelegateAdapter == null || absDelegateAdapter.getOnAdapterItemLongClickListener() == null) {
            return false;
        }
        return absDelegateAdapter.getOnAdapterItemLongClickListener().onItemLongClick(view, item, absDelegateAdapter.getType(), viewGroup, i, j);
    }

    @Override // com.baidu.live.adp.widget.listview.ITypeListAdapter
    public int getPositionByType(int i, int i2) {
        int i3;
        if (this.mLists == null || this.mLists.size() == 0) {
            return -1;
        }
        int size = this.mLists.size();
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            if (this.mLists.get(i4) == null) {
                i3 = i5;
            } else if (this.mLists.get(i4).getType() == null) {
                i3 = i5;
            } else {
                i3 = i2 == this.mLists.get(i4).getType().getId() ? i5 + 1 : i5;
                if (i4 == i) {
                    return i3;
                }
            }
            i4++;
            i5 = i3;
        }
        return -1;
    }

    /* loaded from: classes7.dex */
    public static class ViewHolder {
        private View view;

        public ViewHolder(View view) {
            this.view = null;
            this.view = view;
            if (this.view == null) {
                throw new RuntimeException("view cannt be null");
            }
            this.view.setTag(this);
        }

        public View getView() {
            return this.view;
        }
    }
}
