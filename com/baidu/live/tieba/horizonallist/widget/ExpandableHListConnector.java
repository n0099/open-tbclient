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
/* loaded from: classes3.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter baI;
    private int baK;
    private int baL = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> baJ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.baI != null) {
            this.baI.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.baI = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b cQ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.baJ;
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
            if (i > groupMetadata.baN) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.baM) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.baM) {
                return b.a(i, 2, groupMetadata.baO, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.baN) {
                    return b.a(i, 1, groupMetadata.baO, i - (groupMetadata.baM + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.baN) + groupMetadata2.baO;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.baO - (groupMetadata3.baM - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.live.tieba.horizonallist.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.baJ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.baV, aVar.type, aVar.baV, aVar.baW, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.baV > groupMetadata.baO) {
                i4 = i + 1;
            } else if (aVar.baV < groupMetadata.baO) {
                i3 = i - 1;
            } else if (aVar.baV == groupMetadata.baO) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.baM, aVar.type, aVar.baV, aVar.baW, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.baM + aVar.baW + 1, aVar.type, aVar.baV, aVar.baW, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.baV - groupMetadata2.baO) + groupMetadata2.baN, aVar.type, aVar.baV, aVar.baW, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.baM - (groupMetadata3.baO - aVar.baV), aVar.type, aVar.baV, aVar.baW, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.baI.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b cQ = cQ(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = cQ.baS;
        boolean isChildSelectable = aVar.type == 1 ? this.baI.isChildSelectable(aVar.baV, aVar.baW) : true;
        cQ.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.baI.getGroupCount() + this.baK;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b cQ = cQ(i);
        if (cQ.baS.type == 2) {
            child = this.baI.getGroup(cQ.baS.baV);
        } else if (cQ.baS.type == 1) {
            child = this.baI.getChild(cQ.baS.baV, cQ.baS.baW);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cQ.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b cQ = cQ(i);
        long groupId = this.baI.getGroupId(cQ.baS.baV);
        if (cQ.baS.type == 2) {
            combinedChildId = this.baI.getCombinedGroupId(groupId);
        } else if (cQ.baS.type == 1) {
            combinedChildId = this.baI.getCombinedChildId(groupId, this.baI.getChildId(cQ.baS.baV, cQ.baS.baW));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cQ.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b cQ = cQ(i);
        if (cQ.baS.type == 2) {
            childView = this.baI.getGroupView(cQ.baS.baV, cQ.GK(), view, viewGroup);
        } else if (cQ.baS.type == 1) {
            childView = this.baI.getChildView(cQ.baS.baV, cQ.baS.baW, cQ.baT.baN == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        cQ.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b cQ = cQ(i);
        com.baidu.live.tieba.horizonallist.widget.a aVar = cQ.baS;
        if (this.baI instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.baI;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.baV);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.baV, aVar.baW);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        cQ.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.baI instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.baI;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.baI.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.baJ;
        int size = arrayList.size();
        this.baK = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.baP, groupMetadata.baO);
                if (b2 != groupMetadata.baO) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.baO = b2;
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
            if (groupMetadata2.baN == -1 || z) {
                childrenCount = this.baI.getChildrenCount(groupMetadata2.baO);
            } else {
                childrenCount = groupMetadata2.baN - groupMetadata2.baM;
            }
            this.baK += childrenCount;
            int i5 = i4 + (groupMetadata2.baO - i3);
            i3 = groupMetadata2.baO;
            groupMetadata2.baM = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.baN = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cR(int i) {
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
        if (bVar.baT == null) {
            return false;
        }
        this.baJ.remove(bVar.baT);
        g(false, false);
        notifyDataSetChanged();
        this.baI.onGroupCollapsed(bVar.baT.baO);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.baS.baV < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.baL != 0 && bVar.baT == null) {
            if (this.baJ.size() >= this.baL) {
                GroupMetadata groupMetadata = this.baJ.get(0);
                int indexOf = this.baJ.indexOf(groupMetadata);
                cR(groupMetadata.baO);
                if (bVar.baU > indexOf) {
                    bVar.baU--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.baS.baV, this.baI.getGroupId(bVar.baS.baV));
            this.baJ.add(bVar.baU, b2);
            g(false, false);
            notifyDataSetChanged();
            this.baI.onGroupExpanded(b2.baO);
            return true;
        }
        return false;
    }

    ExpandableListAdapter GH() {
        return this.baI;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter GH = GH();
        if (GH instanceof Filterable) {
            return ((Filterable) GH).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> GI() {
        return this.baJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.baI != null) {
            int groupCount = this.baI.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).baO >= groupCount) {
                    return;
                }
            }
            this.baJ = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter GH = GH();
        if (GH != null) {
            return GH.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.baI.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter GH = GH();
        if (GH == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (GH.getGroupId(i3) != j) {
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
    /* loaded from: classes3.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.live.tieba.horizonallist.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: l */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: cS */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int baM;
        int baN;
        int baO;
        long baP;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.baM = i;
            groupMetadata.baN = i2;
            groupMetadata.baO = i3;
            groupMetadata.baP = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.baO - groupMetadata.baO;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.baM);
            parcel.writeInt(this.baN);
            parcel.writeInt(this.baO);
            parcel.writeLong(this.baP);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static ArrayList<b> baR = new ArrayList<>(5);
        public com.baidu.live.tieba.horizonallist.widget.a baS;
        public GroupMetadata baT;
        public int baU;

        private void resetState() {
            if (this.baS != null) {
                this.baS.recycle();
                this.baS = null;
            }
            this.baT = null;
            this.baU = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b GJ = GJ();
            GJ.baS = com.baidu.live.tieba.horizonallist.widget.a.g(i2, i3, i4, i);
            GJ.baT = groupMetadata;
            GJ.baU = i5;
            return GJ;
        }

        private static b GJ() {
            b bVar;
            synchronized (baR) {
                if (baR.size() > 0) {
                    bVar = baR.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (baR) {
                if (baR.size() < 5) {
                    baR.add(this);
                }
            }
        }

        public boolean GK() {
            return this.baT != null;
        }
    }
}
