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
/* loaded from: classes11.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter bIe;
    private int bIg;
    private int bIh = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bIf = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bIe != null) {
            this.bIe.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bIe = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ex(int i) {
        int i2;
        int i3;
        ArrayList<GroupMetadata> arrayList = this.bIf;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 <= i4) {
            int i7 = ((i4 - i6) / 2) + i6;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i > groupMetadata.bIj) {
                i6 = i7 + 1;
                i5 = i7;
            } else if (i < groupMetadata.bIi) {
                i4 = i7 - 1;
                i5 = i7;
            } else if (i == groupMetadata.bIi) {
                return b.a(i, 2, groupMetadata.bIk, -1, groupMetadata, i7);
            } else {
                if (i <= groupMetadata.bIj) {
                    return b.a(i, 1, groupMetadata.bIk, i - (groupMetadata.bIi + 1), groupMetadata, i7);
                }
                i5 = i7;
            }
        }
        if (i6 > i5) {
            GroupMetadata groupMetadata2 = arrayList.get(i6 - 1);
            i3 = (i - groupMetadata2.bIj) + groupMetadata2.bIk;
            i2 = i6;
        } else if (i4 < i5) {
            i2 = i4 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bIk - (groupMetadata3.bIi - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.bIf;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            return b.a(aVar.bIr, aVar.type, aVar.bIr, aVar.bIs, null, 0);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = ((i - i3) / 2) + i3;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (aVar.bIr > groupMetadata.bIk) {
                i2 = i4;
                i3 = i4 + 1;
            } else if (aVar.bIr < groupMetadata.bIk) {
                i = i4 - 1;
                i2 = i4;
            } else if (aVar.bIr == groupMetadata.bIk) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bIi, aVar.type, aVar.bIr, aVar.bIs, groupMetadata, i4);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bIi + aVar.bIs + 1, aVar.type, aVar.bIr, aVar.bIs, groupMetadata, i4);
                }
                return null;
            } else {
                i2 = i4;
            }
        }
        if (aVar.type == 2) {
            if (i3 > i2) {
                GroupMetadata groupMetadata2 = arrayList.get(i3 - 1);
                return b.a((aVar.bIr - groupMetadata2.bIk) + groupMetadata2.bIj, aVar.type, aVar.bIr, aVar.bIs, null, i3);
            } else if (i < i2) {
                int i5 = i + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bIi - (groupMetadata3.bIk - aVar.bIr), aVar.type, aVar.bIr, aVar.bIs, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bIe.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ex = ex(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = ex.bIo;
        boolean isChildSelectable = aVar.type == 1 ? this.bIe.isChildSelectable(aVar.bIr, aVar.bIs) : true;
        ex.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bIe.getGroupCount() + this.bIg;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ex = ex(i);
        if (ex.bIo.type == 2) {
            child = this.bIe.getGroup(ex.bIo.bIr);
        } else if (ex.bIo.type == 1) {
            child = this.bIe.getChild(ex.bIo.bIr, ex.bIo.bIs);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ex.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ex = ex(i);
        long groupId = this.bIe.getGroupId(ex.bIo.bIr);
        if (ex.bIo.type == 2) {
            combinedChildId = this.bIe.getCombinedGroupId(groupId);
        } else if (ex.bIo.type == 1) {
            combinedChildId = this.bIe.getCombinedChildId(groupId, this.bIe.getChildId(ex.bIo.bIr, ex.bIo.bIs));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ex.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ex = ex(i);
        if (ex.bIo.type == 2) {
            childView = this.bIe.getGroupView(ex.bIo.bIr, ex.isExpanded(), view, viewGroup);
        } else if (ex.bIo.type == 1) {
            childView = this.bIe.getChildView(ex.bIo.bIr, ex.bIo.bIs, ex.bIp.bIj == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ex.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ex = ex(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = ex.bIo;
        if (this.bIe instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bIe;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bIr);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bIr, aVar.bIs);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ex.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bIe instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bIe;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bIe.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        ArrayList<GroupMetadata> arrayList = this.bIf;
        int size = arrayList.size();
        this.bIg = 0;
        if (z2) {
            int i = size - 1;
            boolean z4 = false;
            while (i >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i);
                int k = k(groupMetadata.bIl, groupMetadata.bIk);
                if (k != groupMetadata.bIk) {
                    if (k == -1) {
                        arrayList.remove(i);
                        size--;
                    }
                    groupMetadata.bIk = k;
                    if (!z4) {
                        z3 = true;
                        i--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i2);
            if (groupMetadata2.bIj == -1 || z) {
                childrenCount = this.bIe.getChildrenCount(groupMetadata2.bIk);
            } else {
                childrenCount = groupMetadata2.bIj - groupMetadata2.bIi;
            }
            this.bIg += childrenCount;
            int i5 = i4 + (groupMetadata2.bIk - i3);
            int i6 = groupMetadata2.bIk;
            groupMetadata2.bIi = i5;
            int i7 = childrenCount + i5;
            groupMetadata2.bIj = i7;
            i2++;
            i3 = i6;
            i4 = i7;
        }
    }

    boolean ey(int i) {
        com.baidu.live.tieba.horizonallist.widget.a j = com.baidu.live.tieba.horizonallist.widget.a.j(2, i, -1, -1);
        b a2 = a(j);
        j.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.bIp == null) {
            return false;
        }
        this.bIf.remove(bVar.bIp);
        h(false, false);
        notifyDataSetChanged();
        this.bIe.onGroupCollapsed(bVar.bIp.bIk);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bIo.bIr < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bIh != 0 && bVar.bIp == null) {
            if (this.bIf.size() >= this.bIh) {
                GroupMetadata groupMetadata = this.bIf.get(0);
                int indexOf = this.bIf.indexOf(groupMetadata);
                ey(groupMetadata.bIk);
                if (bVar.bIq > indexOf) {
                    bVar.bIq--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.bIo.bIr, this.bIe.getGroupId(bVar.bIo.bIr));
            this.bIf.add(bVar.bIq, b2);
            h(false, false);
            notifyDataSetChanged();
            this.bIe.onGroupExpanded(b2.bIk);
            return true;
        }
        return false;
    }

    ExpandableListAdapter TN() {
        return this.bIe;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter TN = TN();
        if (TN instanceof Filterable) {
            return ((Filterable) TN).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> TO() {
        return this.bIf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bIe != null) {
            int groupCount = this.bIe.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bIk >= groupCount) {
                    return;
                }
            }
            this.bIf = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter TN = TN();
        if (TN != null) {
            return TN.isEmpty();
        }
        return true;
    }

    int k(long j, int i) {
        int groupCount = this.bIe.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter TN = TN();
        if (TN == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (TN.getGroupId(i4) != j) {
                boolean z2 = i2 == groupCount + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i5 = i2 + 1;
                    z = false;
                    i2 = i5;
                    i4 = i5;
                } else if (z2 || (!z && !z3)) {
                    int i6 = i3 - 1;
                    z = true;
                    i3 = i6;
                    i4 = i6;
                }
            } else {
                return i4;
            }
        }
        return -1;
    }

    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ez */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bIi;
        int bIj;
        int bIk;
        long bIl;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bIi = i;
            groupMetadata.bIj = i2;
            groupMetadata.bIk = i3;
            groupMetadata.bIl = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bIk - groupMetadata.bIk;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bIi);
            parcel.writeInt(this.bIj);
            parcel.writeInt(this.bIk);
            parcel.writeLong(this.bIl);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static ArrayList<b> bIn = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a bIo;
        public GroupMetadata bIp;
        public int bIq;

        private void TP() {
            if (this.bIo != null) {
                this.bIo.recycle();
                this.bIo = null;
            }
            this.bIp = null;
            this.bIq = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b TQ = TQ();
            TQ.bIo = com.baidu.live.tieba.horizonallist.widget.a.j(i2, i3, i4, i);
            TQ.bIp = groupMetadata;
            TQ.bIq = i5;
            return TQ;
        }

        private static b TQ() {
            b bVar;
            synchronized (bIn) {
                if (bIn.size() > 0) {
                    bVar = bIn.remove(0);
                    bVar.TP();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            TP();
            synchronized (bIn) {
                if (bIn.size() < 5) {
                    bIn.add(this);
                }
            }
        }

        public boolean isExpanded() {
            return this.bIp != null;
        }
    }
}
