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
    private ExpandableListAdapter azu;
    private int azw;
    private int azx = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> azv = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.azu != null) {
            this.azu.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.azu = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b cu(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
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
            if (i > groupMetadata.azz) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.azy) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.azy) {
                return b.a(i, 2, groupMetadata.azA, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.azz) {
                    return b.a(i, 1, groupMetadata.azA, i - (groupMetadata.azy + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.azz) + groupMetadata2.azA;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.azA - (groupMetadata3.azy - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.azH, aVar.type, aVar.azH, aVar.azI, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.azH > groupMetadata.azA) {
                i4 = i + 1;
            } else if (aVar.azH < groupMetadata.azA) {
                i3 = i - 1;
            } else if (aVar.azH == groupMetadata.azA) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.azy, aVar.type, aVar.azH, aVar.azI, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.azy + aVar.azI + 1, aVar.type, aVar.azH, aVar.azI, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.azH - groupMetadata2.azA) + groupMetadata2.azz, aVar.type, aVar.azH, aVar.azI, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.azy - (groupMetadata3.azA - aVar.azH), aVar.type, aVar.azH, aVar.azI, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.azu.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b cu = cu(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azE;
        boolean isChildSelectable = aVar.type == 1 ? this.azu.isChildSelectable(aVar.azH, aVar.azI) : true;
        cu.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.azu.getGroupCount() + this.azw;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b cu = cu(i);
        if (cu.azE.type == 2) {
            child = this.azu.getGroup(cu.azE.azH);
        } else if (cu.azE.type == 1) {
            child = this.azu.getChild(cu.azE.azH, cu.azE.azI);
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
        long groupId = this.azu.getGroupId(cu.azE.azH);
        if (cu.azE.type == 2) {
            combinedChildId = this.azu.getCombinedGroupId(groupId);
        } else if (cu.azE.type == 1) {
            combinedChildId = this.azu.getCombinedChildId(groupId, this.azu.getChildId(cu.azE.azH, cu.azE.azI));
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
        if (cu.azE.type == 2) {
            childView = this.azu.getGroupView(cu.azE.azH, cu.zP(), view, viewGroup);
        } else if (cu.azE.type == 1) {
            childView = this.azu.getChildView(cu.azE.azH, cu.azE.azI, cu.azF.azz == i, view, viewGroup);
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
        com.baidu.live.tieba.horizonallist.widget.a aVar = cu.azE;
        if (this.azu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azu;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.azH);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.azH, aVar.azI);
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
        if (this.azu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azu;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.azu.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
        int size = arrayList.size();
        this.azw = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.azB, groupMetadata.azA);
                if (b2 != groupMetadata.azA) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.azA = b2;
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
            if (groupMetadata2.azz == -1 || z) {
                childrenCount = this.azu.getChildrenCount(groupMetadata2.azA);
            } else {
                childrenCount = groupMetadata2.azz - groupMetadata2.azy;
            }
            this.azw += childrenCount;
            int i5 = i4 + (groupMetadata2.azA - i3);
            i3 = groupMetadata2.azA;
            groupMetadata2.azy = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.azz = i6;
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
        if (bVar.azF == null) {
            return false;
        }
        this.azv.remove(bVar.azF);
        h(false, false);
        notifyDataSetChanged();
        this.azu.onGroupCollapsed(bVar.azF.azA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.azE.azH < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.azx != 0 && bVar.azF == null) {
            if (this.azv.size() >= this.azx) {
                GroupMetadata groupMetadata = this.azv.get(0);
                int indexOf = this.azv.indexOf(groupMetadata);
                cv(groupMetadata.azA);
                if (bVar.azG > indexOf) {
                    bVar.azG--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.azE.azH, this.azu.getGroupId(bVar.azE.azH));
            this.azv.add(bVar.azG, b2);
            h(false, false);
            notifyDataSetChanged();
            this.azu.onGroupExpanded(b2.azA);
            return true;
        }
        return false;
    }

    ExpandableListAdapter zM() {
        return this.azu;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter zM = zM();
        if (zM instanceof Filterable) {
            return ((Filterable) zM).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> zN() {
        return this.azv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.azu != null) {
            int groupCount = this.azu.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).azA >= groupCount) {
                    return;
                }
            }
            this.azv = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter zM = zM();
        if (zM != null) {
            return zM.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.azu.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter zM = zM();
        if (zM == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (zM.getGroupId(i3) != j) {
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
        int azA;
        long azB;
        int azy;
        int azz;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.azy = i;
            groupMetadata.azz = i2;
            groupMetadata.azA = i3;
            groupMetadata.azB = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.azA - groupMetadata.azA;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.azy);
            parcel.writeInt(this.azz);
            parcel.writeInt(this.azA);
            parcel.writeLong(this.azB);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static ArrayList<b> azD = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a azE;
        public GroupMetadata azF;
        public int azG;

        private void resetState() {
            if (this.azE != null) {
                this.azE.recycle();
                this.azE = null;
            }
            this.azF = null;
            this.azG = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b zO = zO();
            zO.azE = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            zO.azF = groupMetadata;
            zO.azG = i5;
            return zO;
        }

        private static b zO() {
            b bVar;
            synchronized (azD) {
                if (azD.size() > 0) {
                    bVar = azD.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (azD) {
                if (azD.size() < 5) {
                    azD.add(this);
                }
            }
        }

        public boolean zP() {
            return this.azF != null;
        }
    }
}
