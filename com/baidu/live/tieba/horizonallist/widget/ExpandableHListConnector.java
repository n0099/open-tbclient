package com.baidu.live.tieba.horizonallist.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes7.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter blT;
    private int blV;
    private int blW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> blU = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.blT != null) {
            this.blT.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.blT = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b eV(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.blU;
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
            if (i > groupMetadata.blY) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.blX) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.blX) {
                return b.a(i, 2, groupMetadata.blZ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.blY) {
                    return b.a(i, 1, groupMetadata.blZ, i - (groupMetadata.blX + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.blY) + groupMetadata2.blZ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.blZ - (groupMetadata3.blX - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.blU;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bmg, aVar.type, aVar.bmg, aVar.bmh, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bmg > groupMetadata.blZ) {
                i4 = i + 1;
            } else if (aVar.bmg < groupMetadata.blZ) {
                i3 = i - 1;
            } else if (aVar.bmg == groupMetadata.blZ) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.blX, aVar.type, aVar.bmg, aVar.bmh, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.blX + aVar.bmh + 1, aVar.type, aVar.bmg, aVar.bmh, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bmg - groupMetadata2.blZ) + groupMetadata2.blY, aVar.type, aVar.bmg, aVar.bmh, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.blX - (groupMetadata3.blZ - aVar.bmg), aVar.type, aVar.bmg, aVar.bmh, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.blT.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b eV = eV(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmd;
        boolean isChildSelectable = aVar.type == 1 ? this.blT.isChildSelectable(aVar.bmg, aVar.bmh) : true;
        eV.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.blT.getGroupCount() + this.blV;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b eV = eV(i);
        if (eV.bmd.type == 2) {
            child = this.blT.getGroup(eV.bmd.bmg);
        } else if (eV.bmd.type == 1) {
            child = this.blT.getChild(eV.bmd.bmg, eV.bmd.bmh);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        eV.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b eV = eV(i);
        long groupId = this.blT.getGroupId(eV.bmd.bmg);
        if (eV.bmd.type == 2) {
            combinedChildId = this.blT.getCombinedGroupId(groupId);
        } else if (eV.bmd.type == 1) {
            combinedChildId = this.blT.getCombinedChildId(groupId, this.blT.getChildId(eV.bmd.bmg, eV.bmd.bmh));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        eV.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b eV = eV(i);
        if (eV.bmd.type == 2) {
            childView = this.blT.getGroupView(eV.bmd.bmg, eV.NW(), view, viewGroup);
        } else if (eV.bmd.type == 1) {
            childView = this.blT.getChildView(eV.bmd.bmg, eV.bmd.bmh, eV.bme.blY == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        eV.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b eV = eV(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmd;
        if (this.blT instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.blT;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bmg);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bmg, aVar.bmh);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        eV.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.blT instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.blT;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.blT.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.blU;
        int size = arrayList.size();
        this.blV = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bma, groupMetadata.blZ);
                if (b2 != groupMetadata.blZ) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.blZ = b2;
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
            if (groupMetadata2.blY == -1 || z) {
                childrenCount = this.blT.getChildrenCount(groupMetadata2.blZ);
            } else {
                childrenCount = groupMetadata2.blY - groupMetadata2.blX;
            }
            this.blV += childrenCount;
            int i5 = i4 + (groupMetadata2.blZ - i3);
            i3 = groupMetadata2.blZ;
            groupMetadata2.blX = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.blY = i6;
            i++;
            i4 = i6;
        }
    }

    boolean eW(int i) {
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
        if (bVar.bme == null) {
            return false;
        }
        this.blU.remove(bVar.bme);
        g(false, false);
        notifyDataSetChanged();
        this.blT.onGroupCollapsed(bVar.bme.blZ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bmd.bmg < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.blW != 0 && bVar.bme == null) {
            if (this.blU.size() >= this.blW) {
                GroupMetadata groupMetadata = this.blU.get(0);
                int indexOf = this.blU.indexOf(groupMetadata);
                eW(groupMetadata.blZ);
                if (bVar.bmf > indexOf) {
                    bVar.bmf--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bmd.bmg, this.blT.getGroupId(bVar.bmd.bmg));
            this.blU.add(bVar.bmf, a2);
            g(false, false);
            notifyDataSetChanged();
            this.blT.onGroupExpanded(a2.blZ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter NT() {
        return this.blT;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter NT = NT();
        if (NT instanceof Filterable) {
            return ((Filterable) NT).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> NU() {
        return this.blU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.blT != null) {
            int groupCount = this.blT.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).blZ >= groupCount) {
                    return;
                }
            }
            this.blU = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter NT = NT();
        if (NT != null) {
            return NT.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.blT.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter NT = NT();
        if (NT == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (NT.getGroupId(i3) != j) {
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

    /* loaded from: classes7.dex */
    protected class a extends DataSetObserver {
        protected a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: l */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: eX */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int blX;
        int blY;
        int blZ;
        long bma;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.blX = i;
            groupMetadata.blY = i2;
            groupMetadata.blZ = i3;
            groupMetadata.bma = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.blZ - groupMetadata.blZ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.blX);
            parcel.writeInt(this.blY);
            parcel.writeInt(this.blZ);
            parcel.writeLong(this.bma);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        private static ArrayList<b> bmc = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a bmd;
        public GroupMetadata bme;
        public int bmf;

        private void resetState() {
            if (this.bmd != null) {
                this.bmd.recycle();
                this.bmd = null;
            }
            this.bme = null;
            this.bmf = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b NV = NV();
            NV.bmd = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            NV.bme = groupMetadata;
            NV.bmf = i5;
            return NV;
        }

        private static b NV() {
            b bVar;
            synchronized (bmc) {
                if (bmc.size() > 0) {
                    bVar = bmc.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bmc) {
                if (bmc.size() < 5) {
                    bmc.add(this);
                }
            }
        }

        public boolean NW() {
            return this.bme != null;
        }
    }
}
