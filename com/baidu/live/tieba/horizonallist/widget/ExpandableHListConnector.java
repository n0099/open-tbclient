package com.baidu.live.tieba.horizonallist.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes3.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter azI;
    private int azK;
    private int azL = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> azJ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.azI != null) {
            this.azI.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.azI = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b cu(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.azJ;
        int size = arrayList.size();
        int i5 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i6 = i5;
        int i7 = 0;
        while (i7 <= i6) {
            i4 = ((i6 - i7) / 2) + i7;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (i > groupMetadata.azN) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.azM) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.azM) {
                return b.a(i, 2, groupMetadata.azO, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.azN) {
                    return b.a(i, 1, groupMetadata.azO, i - (groupMetadata.azM + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.azN) + groupMetadata2.azO;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.azO - (groupMetadata3.azM - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azJ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.azV, aVar.type, aVar.azV, aVar.azW, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.azV > groupMetadata.azO) {
                i4 = i + 1;
            } else if (aVar.azV < groupMetadata.azO) {
                i3 = i - 1;
            } else if (aVar.azV == groupMetadata.azO) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.azM, aVar.type, aVar.azV, aVar.azW, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.azM + aVar.azW + 1, aVar.type, aVar.azV, aVar.azW, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.azV - groupMetadata2.azO) + groupMetadata2.azN, aVar.type, aVar.azV, aVar.azW, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.azM - (groupMetadata3.azO - aVar.azV), aVar.type, aVar.azV, aVar.azW, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.azI.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b cu = cu(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azS;
        boolean isChildSelectable = aVar.type == 1 ? this.azI.isChildSelectable(aVar.azV, aVar.azW) : true;
        cu.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.azI.getGroupCount() + this.azK;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b cu = cu(i);
        if (cu.azS.type == 2) {
            child = this.azI.getGroup(cu.azS.azV);
        } else if (cu.azS.type == 1) {
            child = this.azI.getChild(cu.azS.azV, cu.azS.azW);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cu.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b cu = cu(i);
        long groupId = this.azI.getGroupId(cu.azS.azV);
        if (cu.azS.type == 2) {
            combinedChildId = this.azI.getCombinedGroupId(groupId);
        } else if (cu.azS.type == 1) {
            combinedChildId = this.azI.getCombinedChildId(groupId, this.azI.getChildId(cu.azS.azV, cu.azS.azW));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cu.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b cu = cu(i);
        if (cu.azS.type == 2) {
            childView = this.azI.getGroupView(cu.azS.azV, cu.zW(), view, viewGroup);
        } else if (cu.azS.type == 1) {
            childView = this.azI.getChildView(cu.azS.azV, cu.azS.azW, cu.azT.azN == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cu.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b cu = cu(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azS;
        if (this.azI instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azI;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.azV);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.azV, aVar.azW);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        cu.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.azI instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azI;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.azI.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azJ;
        int size = arrayList.size();
        this.azK = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.azP, groupMetadata.azO);
                if (b2 != groupMetadata.azO) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.azO = b2;
                    if (!z4) {
                        z3 = true;
                        i2--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i2--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            if (groupMetadata2.azN == -1 || z) {
                childrenCount = this.azI.getChildrenCount(groupMetadata2.azO);
            } else {
                childrenCount = groupMetadata2.azN - groupMetadata2.azM;
            }
            this.azK += childrenCount;
            int i5 = i4 + (groupMetadata2.azO - i3);
            i3 = groupMetadata2.azO;
            groupMetadata2.azM = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.azN = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cv(int i) {
        com.baidu.live.tieba.horizonallist.widget.a g = com.baidu.live.tieba.horizonallist.widget.a.g(2, i, -1, -1);
        b a2 = a(g);
        g.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.azT == null) {
            return false;
        }
        this.azJ.remove(bVar.azT);
        h(false, false);
        notifyDataSetChanged();
        this.azI.onGroupCollapsed(bVar.azT.azO);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.azS.azV < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.azL != 0 && bVar.azT == null) {
            if (this.azJ.size() >= this.azL) {
                GroupMetadata groupMetadata = this.azJ.get(0);
                int indexOf = this.azJ.indexOf(groupMetadata);
                cv(groupMetadata.azO);
                if (bVar.azU > indexOf) {
                    bVar.azU--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.azS.azV, this.azI.getGroupId(bVar.azS.azV));
            this.azJ.add(bVar.azU, b2);
            h(false, false);
            notifyDataSetChanged();
            this.azI.onGroupExpanded(b2.azO);
            return true;
        }
        return false;
    }

    ExpandableListAdapter zT() {
        return this.azI;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter zT = zT();
        if (zT instanceof Filterable) {
            return ((Filterable) zT).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> zU() {
        return this.azJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.azI != null) {
            int groupCount = this.azI.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).azO >= groupCount) {
                    return;
                }
            }
            this.azJ = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter zT = zT();
        if (zT != null) {
            return zT.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.azI.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter zT = zT();
        if (zT == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (zT.getGroupId(i3) != j) {
                boolean z2 = min == groupCount + (-1);
                boolean z3 = i2 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    min++;
                    z = false;
                    i3 = min;
                } else if (z2 || (!z && !z3)) {
                    i2--;
                    z = true;
                    i3 = i2;
                }
            } else {
                return i3;
            }
        }
        return -1;
    }

    /* loaded from: classes3.dex */
    protected class a extends DataSetObserver {
        protected a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: cw */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int azM;
        int azN;
        int azO;
        long azP;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.azM = i;
            groupMetadata.azN = i2;
            groupMetadata.azO = i3;
            groupMetadata.azP = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.azO - groupMetadata.azO;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.azM);
            parcel.writeInt(this.azN);
            parcel.writeInt(this.azO);
            parcel.writeLong(this.azP);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static ArrayList<b> azR = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a azS;
        public GroupMetadata azT;
        public int azU;

        private void resetState() {
            if (this.azS != null) {
                this.azS.recycle();
                this.azS = null;
            }
            this.azT = null;
            this.azU = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b zV = zV();
            zV.azS = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            zV.azT = groupMetadata;
            zV.azU = i5;
            return zV;
        }

        private static b zV() {
            b bVar;
            synchronized (azR) {
                if (azR.size() > 0) {
                    bVar = azR.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (azR) {
                if (azR.size() < 5) {
                    azR.add(this);
                }
            }
        }

        public boolean zW() {
            return this.azT != null;
        }
    }
}
