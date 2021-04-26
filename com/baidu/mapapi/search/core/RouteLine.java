package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import java.util.List;
/* loaded from: classes2.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public TYPE f7442a;

    /* renamed from: b  reason: collision with root package name */
    public RouteNode f7443b;

    /* renamed from: c  reason: collision with root package name */
    public RouteNode f7444c;

    /* renamed from: d  reason: collision with root package name */
    public String f7445d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f7446e;

    /* renamed from: f  reason: collision with root package name */
    public int f7447f;

    /* renamed from: g  reason: collision with root package name */
    public int f7448g;

    /* loaded from: classes2.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7450a;

        TYPE(int i2) {
            this.f7450a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f7450a;
        }
    }

    public RouteLine() {
    }

    public RouteLine(Parcel parcel) {
        Object obj;
        int readInt = parcel.readInt();
        this.f7443b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7444c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7445d = parcel.readString();
        if (readInt == 0) {
            obj = DrivingRouteLine.DrivingStep.CREATOR;
        } else if (readInt == 1) {
            obj = TransitRouteLine.TransitStep.CREATOR;
        } else if (readInt != 2) {
            if (readInt == 3) {
                obj = BikingRouteLine.BikingStep.CREATOR;
            }
            this.f7447f = parcel.readInt();
            this.f7448g = parcel.readInt();
        } else {
            obj = WalkingRouteLine.WalkingStep.CREATOR;
        }
        this.f7446e = parcel.createTypedArrayList(obj);
        this.f7447f = parcel.readInt();
        this.f7448g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.f7446e;
    }

    public int getDistance() {
        return this.f7447f;
    }

    public int getDuration() {
        return this.f7448g;
    }

    public RouteNode getStarting() {
        return this.f7443b;
    }

    public RouteNode getTerminal() {
        return this.f7444c;
    }

    public String getTitle() {
        return this.f7445d;
    }

    public TYPE getType() {
        return this.f7442a;
    }

    public void setDistance(int i2) {
        this.f7447f = i2;
    }

    public void setDuration(int i2) {
        this.f7448g = i2;
    }

    public void setStarting(RouteNode routeNode) {
        this.f7443b = routeNode;
    }

    public void setSteps(List<T> list) {
        this.f7446e = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.f7444c = routeNode;
    }

    public void setTitle(String str) {
        this.f7445d = str;
    }

    public void setType(TYPE type) {
        this.f7442a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        TYPE type = this.f7442a;
        parcel.writeInt(type != null ? type.a() : 10);
        parcel.writeValue(this.f7443b);
        parcel.writeValue(this.f7444c);
        parcel.writeString(this.f7445d);
        if (this.f7442a != null) {
            parcel.writeTypedList(this.f7446e);
        }
        parcel.writeInt(this.f7447f);
        parcel.writeInt(this.f7448g);
    }
}
