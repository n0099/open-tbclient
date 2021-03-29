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
    public TYPE f7151a;

    /* renamed from: b  reason: collision with root package name */
    public RouteNode f7152b;

    /* renamed from: c  reason: collision with root package name */
    public RouteNode f7153c;

    /* renamed from: d  reason: collision with root package name */
    public String f7154d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f7155e;

    /* renamed from: f  reason: collision with root package name */
    public int f7156f;

    /* renamed from: g  reason: collision with root package name */
    public int f7157g;

    /* loaded from: classes2.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7159a;

        TYPE(int i) {
            this.f7159a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f7159a;
        }
    }

    public RouteLine() {
    }

    public RouteLine(Parcel parcel) {
        Object obj;
        int readInt = parcel.readInt();
        this.f7152b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7153c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7154d = parcel.readString();
        if (readInt == 0) {
            obj = DrivingRouteLine.DrivingStep.CREATOR;
        } else if (readInt == 1) {
            obj = TransitRouteLine.TransitStep.CREATOR;
        } else if (readInt != 2) {
            if (readInt == 3) {
                obj = BikingRouteLine.BikingStep.CREATOR;
            }
            this.f7156f = parcel.readInt();
            this.f7157g = parcel.readInt();
        } else {
            obj = WalkingRouteLine.WalkingStep.CREATOR;
        }
        this.f7155e = parcel.createTypedArrayList(obj);
        this.f7156f = parcel.readInt();
        this.f7157g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.f7155e;
    }

    public int getDistance() {
        return this.f7156f;
    }

    public int getDuration() {
        return this.f7157g;
    }

    public RouteNode getStarting() {
        return this.f7152b;
    }

    public RouteNode getTerminal() {
        return this.f7153c;
    }

    public String getTitle() {
        return this.f7154d;
    }

    public TYPE getType() {
        return this.f7151a;
    }

    public void setDistance(int i) {
        this.f7156f = i;
    }

    public void setDuration(int i) {
        this.f7157g = i;
    }

    public void setStarting(RouteNode routeNode) {
        this.f7152b = routeNode;
    }

    public void setSteps(List<T> list) {
        this.f7155e = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.f7153c = routeNode;
    }

    public void setTitle(String str) {
        this.f7154d = str;
    }

    public void setType(TYPE type) {
        this.f7151a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TYPE type = this.f7151a;
        parcel.writeInt(type != null ? type.a() : 10);
        parcel.writeValue(this.f7152b);
        parcel.writeValue(this.f7153c);
        parcel.writeString(this.f7154d);
        if (this.f7151a != null) {
            parcel.writeTypedList(this.f7155e);
        }
        parcel.writeInt(this.f7156f);
        parcel.writeInt(this.f7157g);
    }
}
