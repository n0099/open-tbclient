package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import java.util.List;
/* loaded from: classes15.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    TYPE f2967a;

    /* renamed from: b  reason: collision with root package name */
    private RouteNode f2968b;
    private RouteNode c;
    private String d;
    private List<T> e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes15.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        

        /* renamed from: a  reason: collision with root package name */
        private int f2970a;

        TYPE(int i) {
            this.f2970a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f2970a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLine() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLine(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f2968b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.d = parcel.readString();
        switch (readInt) {
            case 0:
                this.e = parcel.createTypedArrayList(DrivingRouteLine.DrivingStep.CREATOR);
                break;
            case 1:
                this.e = parcel.createTypedArrayList(TransitRouteLine.TransitStep.CREATOR);
                break;
            case 2:
                this.e = parcel.createTypedArrayList(WalkingRouteLine.WalkingStep.CREATOR);
                break;
            case 3:
                this.e = parcel.createTypedArrayList(BikingRouteLine.BikingStep.CREATOR);
                break;
        }
        this.f = parcel.readInt();
        this.g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.e;
    }

    public int getDistance() {
        return this.f;
    }

    public int getDuration() {
        return this.g;
    }

    public RouteNode getStarting() {
        return this.f2968b;
    }

    public RouteNode getTerminal() {
        return this.c;
    }

    public String getTitle() {
        return this.d;
    }

    protected TYPE getType() {
        return this.f2967a;
    }

    public void setDistance(int i) {
        this.f = i;
    }

    public void setDuration(int i) {
        this.g = i;
    }

    public void setStarting(RouteNode routeNode) {
        this.f2968b = routeNode;
    }

    public void setSteps(List<T> list) {
        this.e = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.c = routeNode;
    }

    public void setTitle(String str) {
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setType(TYPE type) {
        this.f2967a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f2967a != null) {
            parcel.writeInt(this.f2967a.a());
        } else {
            parcel.writeInt(10);
        }
        parcel.writeValue(this.f2968b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        if (this.f2967a != null) {
            parcel.writeTypedList(this.e);
        }
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }
}
