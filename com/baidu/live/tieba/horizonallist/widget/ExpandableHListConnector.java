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
    private ExpandableListAdapter blW;
    private int blY;
    private int blZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> blX = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.blW != null) {
            this.blW.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.blW = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b eV(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.blX;
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
            if (i > groupMetadata.bmb) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bma) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bma) {
                return b.a(i, 2, groupMetadata.bmc, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bmb) {
                    return b.a(i, 1, groupMetadata.bmc, i - (groupMetadata.bma + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bmb) + groupMetadata2.bmc;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bmc - (groupMetadata3.bma - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.blX;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bmj, aVar.type, aVar.bmj, aVar.bmk, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bmj > groupMetadata.bmc) {
                i4 = i + 1;
            } else if (aVar.bmj < groupMetadata.bmc) {
                i3 = i - 1;
            } else if (aVar.bmj == groupMetadata.bmc) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bma, aVar.type, aVar.bmj, aVar.bmk, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bma + aVar.bmk + 1, aVar.type, aVar.bmj, aVar.bmk, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bmj - groupMetadata2.bmc) + groupMetadata2.bmb, aVar.type, aVar.bmj, aVar.bmk, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bma - (groupMetadata3.bmc - aVar.bmj), aVar.type, aVar.bmj, aVar.bmk, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.blW.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b eV = eV(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmg;
        boolean isChildSelectable = aVar.type == 1 ? this.blW.isChildSelectable(aVar.bmj, aVar.bmk) : true;
        eV.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.blW.getGroupCount() + this.blY;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b eV = eV(i);
        if (eV.bmg.type == 2) {
            child = this.blW.getGroup(eV.bmg.bmj);
        } else if (eV.bmg.type == 1) {
            child = this.blW.getChild(eV.bmg.bmj, eV.bmg.bmk);
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
        long groupId = this.blW.getGroupId(eV.bmg.bmj);
        if (eV.bmg.type == 2) {
            combinedChildId = this.blW.getCombinedGroupId(groupId);
        } else if (eV.bmg.type == 1) {
            combinedChildId = this.blW.getCombinedChildId(groupId, this.blW.getChildId(eV.bmg.bmj, eV.bmg.bmk));
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
        if (eV.bmg.type == 2) {
            childView = this.blW.getGroupView(eV.bmg.bmj, eV.NW(), view, viewGroup);
        } else if (eV.bmg.type == 1) {
            childView = this.blW.getChildView(eV.bmg.bmj, eV.bmg.bmk, eV.bmh.bmb == i, view, viewGroup);
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
        com.baidu.live.tieba.horizonallist.widget.a aVar = eV.bmg;
        if (this.blW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.blW;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bmj);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bmj, aVar.bmk);
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
        if (this.blW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.blW;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.blW.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.blX;
        int size = arrayList.size();
        this.blY = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bmd, groupMetadata.bmc);
                if (b2 != groupMetadata.bmc) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bmc = b2;
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
            if (groupMetadata2.bmb == -1 || z) {
                childrenCount = this.blW.getChildrenCount(groupMetadata2.bmc);
            } else {
                childrenCount = groupMetadata2.bmb - groupMetadata2.bma;
            }
            this.blY += childrenCount;
            int i5 = i4 + (groupMetadata2.bmc - i3);
            i3 = groupMetadata2.bmc;
            groupMetadata2.bma = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bmb = i6;
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
        if (bVar.bmh == null) {
            return false;
        }
        this.blX.remove(bVar.bmh);
        g(false, false);
        notifyDataSetChanged();
        this.blW.onGroupCollapsed(bVar.bmh.bmc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bmg.bmj < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.blZ != 0 && bVar.bmh == null) {
            if (this.blX.size() >= this.blZ) {
                GroupMetadata groupMetadata = this.blX.get(0);
                int indexOf = this.blX.indexOf(groupMetadata);
                eW(groupMetadata.bmc);
                if (bVar.bmi > indexOf) {
                    bVar.bmi--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bmg.bmj, this.blW.getGroupId(bVar.bmg.bmj));
            this.blX.add(bVar.bmi, a2);
            g(false, false);
            notifyDataSetChanged();
            this.blW.onGroupExpanded(a2.bmc);
            return true;
        }
        return false;
    }

    ExpandableListAdapter NT() {
        return this.blW;
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
        return this.blX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.blW != null) {
            int groupCount = this.blW.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bmc >= groupCount) {
                    return;
                }
            }
            this.blX = arrayList;
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
        int groupCount = this.blW.getGroupCount();
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
        int bma;
        int bmb;
        int bmc;
        long bmd;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bma = i;
            groupMetadata.bmb = i2;
            groupMetadata.bmc = i3;
            groupMetadata.bmd = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bmc - groupMetadata.bmc;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bma);
            parcel.writeInt(this.bmb);
            parcel.writeInt(this.bmc);
            parcel.writeLong(this.bmd);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        private static ArrayList<b> bmf = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a bmg;
        public GroupMetadata bmh;
        public int bmi;

        private void resetState() {
            if (this.bmg != null) {
                this.bmg.recycle();
                this.bmg = null;
            }
            this.bmh = null;
            this.bmi = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b NV = NV();
            NV.bmg = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            NV.bmh = groupMetadata;
            NV.bmi = i5;
            return NV;
        }

        private static b NV() {
            b bVar;
            synchronized (bmf) {
                if (bmf.size() > 0) {
                    bVar = bmf.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bmf) {
                if (bmf.size() < 5) {
                    bmf.add(this);
                }
            }
        }

        public boolean NW() {
            return this.bmh != null;
        }
    }
}
