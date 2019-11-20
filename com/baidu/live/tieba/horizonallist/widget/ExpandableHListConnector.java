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
/* loaded from: classes6.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter ams;
    private int amu;
    private int amv = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> amt = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ams != null) {
            this.ams.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ams = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b bL(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.amt;
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
            if (i > groupMetadata.amx) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.amw) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.amw) {
                return b.a(i, 2, groupMetadata.amy, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.amx) {
                    return b.a(i, 1, groupMetadata.amy, i - (groupMetadata.amw + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.amx) + groupMetadata2.amy;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.amy - (groupMetadata3.amw - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.amt;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.amF, aVar.type, aVar.amF, aVar.amG, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.amF > groupMetadata.amy) {
                i4 = i + 1;
            } else if (aVar.amF < groupMetadata.amy) {
                i3 = i - 1;
            } else if (aVar.amF == groupMetadata.amy) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.amw, aVar.type, aVar.amF, aVar.amG, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.amw + aVar.amG + 1, aVar.type, aVar.amF, aVar.amG, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.amF - groupMetadata2.amy) + groupMetadata2.amx, aVar.type, aVar.amF, aVar.amG, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.amw - (groupMetadata3.amy - aVar.amF), aVar.type, aVar.amF, aVar.amG, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ams.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b bL = bL(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = bL.amC;
        boolean isChildSelectable = aVar.type == 1 ? this.ams.isChildSelectable(aVar.amF, aVar.amG) : true;
        bL.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ams.getGroupCount() + this.amu;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b bL = bL(i);
        if (bL.amC.type == 2) {
            child = this.ams.getGroup(bL.amC.amF);
        } else if (bL.amC.type == 1) {
            child = this.ams.getChild(bL.amC.amF, bL.amC.amG);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        bL.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b bL = bL(i);
        long groupId = this.ams.getGroupId(bL.amC.amF);
        if (bL.amC.type == 2) {
            combinedChildId = this.ams.getCombinedGroupId(groupId);
        } else if (bL.amC.type == 1) {
            combinedChildId = this.ams.getCombinedChildId(groupId, this.ams.getChildId(bL.amC.amF, bL.amC.amG));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        bL.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b bL = bL(i);
        if (bL.amC.type == 2) {
            childView = this.ams.getGroupView(bL.amC.amF, bL.vi(), view, viewGroup);
        } else if (bL.amC.type == 1) {
            childView = this.ams.getChildView(bL.amC.amF, bL.amC.amG, bL.amD.amx == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        bL.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b bL = bL(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = bL.amC;
        if (this.ams instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ams;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.amF);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.amF, aVar.amG);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        bL.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ams instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ams;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ams.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.amt;
        int size = arrayList.size();
        this.amu = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.amz, groupMetadata.amy);
                if (b2 != groupMetadata.amy) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.amy = b2;
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
            if (groupMetadata2.amx == -1 || z) {
                childrenCount = this.ams.getChildrenCount(groupMetadata2.amy);
            } else {
                childrenCount = groupMetadata2.amx - groupMetadata2.amw;
            }
            this.amu += childrenCount;
            int i5 = i4 + (groupMetadata2.amy - i3);
            i3 = groupMetadata2.amy;
            groupMetadata2.amw = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.amx = i6;
            i++;
            i4 = i6;
        }
    }

    boolean bM(int i) {
        com.baidu.live.tieba.horizonallist.widget.a f = com.baidu.live.tieba.horizonallist.widget.a.f(2, i, -1, -1);
        b a2 = a(f);
        f.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.amD == null) {
            return false;
        }
        this.amt.remove(bVar.amD);
        f(false, false);
        notifyDataSetChanged();
        this.ams.onGroupCollapsed(bVar.amD.amy);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.amC.amF < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.amv != 0 && bVar.amD == null) {
            if (this.amt.size() >= this.amv) {
                GroupMetadata groupMetadata = this.amt.get(0);
                int indexOf = this.amt.indexOf(groupMetadata);
                bM(groupMetadata.amy);
                if (bVar.amE > indexOf) {
                    bVar.amE--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.amC.amF, this.ams.getGroupId(bVar.amC.amF));
            this.amt.add(bVar.amE, b2);
            f(false, false);
            notifyDataSetChanged();
            this.ams.onGroupExpanded(b2.amy);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ve() {
        return this.ams;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ve = ve();
        if (ve instanceof Filterable) {
            return ((Filterable) ve).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> vf() {
        return this.amt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ams != null) {
            int groupCount = this.ams.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).amy >= groupCount) {
                    return;
                }
            }
            this.amt = arrayList;
            f(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ve = ve();
        if (ve != null) {
            return ve.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.ams.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ve = ve();
        if (ve == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ve.getGroupId(i3) != j) {
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

    /* loaded from: classes6.dex */
    protected class a extends DataSetObserver {
        protected a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.f(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.f(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
            /* renamed from: bN */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int amw;
        int amx;
        int amy;
        long amz;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.amw = i;
            groupMetadata.amx = i2;
            groupMetadata.amy = i3;
            groupMetadata.amz = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.amy - groupMetadata.amy;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.amw);
            parcel.writeInt(this.amx);
            parcel.writeInt(this.amy);
            parcel.writeLong(this.amz);
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        private static ArrayList<b> amB = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a amC;
        public GroupMetadata amD;
        public int amE;

        private void vg() {
            if (this.amC != null) {
                this.amC.recycle();
                this.amC = null;
            }
            this.amD = null;
            this.amE = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b vh = vh();
            vh.amC = com.baidu.live.tieba.horizonallist.widget.a.f(i2, i3, i4, i);
            vh.amD = groupMetadata;
            vh.amE = i5;
            return vh;
        }

        private static b vh() {
            b bVar;
            synchronized (amB) {
                if (amB.size() > 0) {
                    bVar = amB.remove(0);
                    bVar.vg();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            vg();
            synchronized (amB) {
                if (amB.size() < 5) {
                    amB.add(this);
                }
            }
        }

        public boolean vi() {
            return this.amD != null;
        }
    }
}
