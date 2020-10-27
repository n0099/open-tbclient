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
/* loaded from: classes4.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter buK;
    private int buM;
    private int buN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> buL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.buK != null) {
            this.buK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.buK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b fr(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.buL;
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
            if (i > groupMetadata.buP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.buO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.buO) {
                return b.a(i, 2, groupMetadata.buQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.buP) {
                    return b.a(i, 1, groupMetadata.buQ, i - (groupMetadata.buO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.buP) + groupMetadata2.buQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.buQ - (groupMetadata3.buO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.buL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.buX, aVar.type, aVar.buX, aVar.buY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.buX > groupMetadata.buQ) {
                i4 = i + 1;
            } else if (aVar.buX < groupMetadata.buQ) {
                i3 = i - 1;
            } else if (aVar.buX == groupMetadata.buQ) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.buO, aVar.type, aVar.buX, aVar.buY, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.buO + aVar.buY + 1, aVar.type, aVar.buX, aVar.buY, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.buX - groupMetadata2.buQ) + groupMetadata2.buP, aVar.type, aVar.buX, aVar.buY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.buO - (groupMetadata3.buQ - aVar.buX), aVar.type, aVar.buX, aVar.buY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.buK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b fr = fr(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = fr.buU;
        boolean isChildSelectable = aVar.type == 1 ? this.buK.isChildSelectable(aVar.buX, aVar.buY) : true;
        fr.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.buK.getGroupCount() + this.buM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b fr = fr(i);
        if (fr.buU.type == 2) {
            child = this.buK.getGroup(fr.buU.buX);
        } else if (fr.buU.type == 1) {
            child = this.buK.getChild(fr.buU.buX, fr.buU.buY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        fr.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b fr = fr(i);
        long groupId = this.buK.getGroupId(fr.buU.buX);
        if (fr.buU.type == 2) {
            combinedChildId = this.buK.getCombinedGroupId(groupId);
        } else if (fr.buU.type == 1) {
            combinedChildId = this.buK.getCombinedChildId(groupId, this.buK.getChildId(fr.buU.buX, fr.buU.buY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        fr.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b fr = fr(i);
        if (fr.buU.type == 2) {
            childView = this.buK.getGroupView(fr.buU.buX, fr.Qx(), view, viewGroup);
        } else if (fr.buU.type == 1) {
            childView = this.buK.getChildView(fr.buU.buX, fr.buU.buY, fr.buV.buP == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        fr.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b fr = fr(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = fr.buU;
        if (this.buK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.buK;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.buX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.buX, aVar.buY);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        fr.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.buK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.buK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.buK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.buL;
        int size = arrayList.size();
        this.buM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int f = f(groupMetadata.buR, groupMetadata.buQ);
                if (f != groupMetadata.buQ) {
                    if (f == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.buQ = f;
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
            if (groupMetadata2.buP == -1 || z) {
                childrenCount = this.buK.getChildrenCount(groupMetadata2.buQ);
            } else {
                childrenCount = groupMetadata2.buP - groupMetadata2.buO;
            }
            this.buM += childrenCount;
            int i5 = i4 + (groupMetadata2.buQ - i3);
            i3 = groupMetadata2.buQ;
            groupMetadata2.buO = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.buP = i6;
            i++;
            i4 = i6;
        }
    }

    boolean fs(int i) {
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
        if (bVar.buV == null) {
            return false;
        }
        this.buL.remove(bVar.buV);
        g(false, false);
        notifyDataSetChanged();
        this.buK.onGroupCollapsed(bVar.buV.buQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.buU.buX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.buN != 0 && bVar.buV == null) {
            if (this.buL.size() >= this.buN) {
                GroupMetadata groupMetadata = this.buL.get(0);
                int indexOf = this.buL.indexOf(groupMetadata);
                fs(groupMetadata.buQ);
                if (bVar.buW > indexOf) {
                    bVar.buW--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.buU.buX, this.buK.getGroupId(bVar.buU.buX));
            this.buL.add(bVar.buW, a2);
            g(false, false);
            notifyDataSetChanged();
            this.buK.onGroupExpanded(a2.buQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Qu() {
        return this.buK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Qu = Qu();
        if (Qu instanceof Filterable) {
            return ((Filterable) Qu).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Qv() {
        return this.buL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.buK != null) {
            int groupCount = this.buK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).buQ >= groupCount) {
                    return;
                }
            }
            this.buL = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Qu = Qu();
        if (Qu != null) {
            return Qu.isEmpty();
        }
        return true;
    }

    int f(long j, int i) {
        int groupCount = this.buK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Qu = Qu();
        if (Qu == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Qu.getGroupId(i3) != j) {
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

    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
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
            /* renamed from: ft */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int buO;
        int buP;
        int buQ;
        long buR;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.buO = i;
            groupMetadata.buP = i2;
            groupMetadata.buQ = i3;
            groupMetadata.buR = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.buQ - groupMetadata.buQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.buO);
            parcel.writeInt(this.buP);
            parcel.writeInt(this.buQ);
            parcel.writeLong(this.buR);
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        private static ArrayList<b> buT = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a buU;
        public GroupMetadata buV;
        public int buW;

        private void resetState() {
            if (this.buU != null) {
                this.buU.recycle();
                this.buU = null;
            }
            this.buV = null;
            this.buW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b Qw = Qw();
            Qw.buU = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            Qw.buV = groupMetadata;
            Qw.buW = i5;
            return Qw;
        }

        private static b Qw() {
            b bVar;
            synchronized (buT) {
                if (buT.size() > 0) {
                    bVar = buT.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (buT) {
                if (buT.size() < 5) {
                    buT.add(this);
                }
            }
        }

        public boolean Qx() {
            return this.buV != null;
        }
    }
}
