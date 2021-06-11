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
    public TYPE f7202a;

    /* renamed from: b  reason: collision with root package name */
    public RouteNode f7203b;

    /* renamed from: c  reason: collision with root package name */
    public RouteNode f7204c;

    /* renamed from: d  reason: collision with root package name */
    public String f7205d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f7206e;

    /* renamed from: f  reason: collision with root package name */
    public int f7207f;

    /* renamed from: g  reason: collision with root package name */
    public int f7208g;

    /* loaded from: classes2.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7210a;

        TYPE(int i2) {
            this.f7210a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f7210a;
        }
    }

    public RouteLine() {
    }

    public RouteLine(Parcel parcel) {
        Object obj;
        int readInt = parcel.readInt();
        this.f7203b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7204c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7205d = parcel.readString();
        if (readInt == 0) {
            obj = DrivingRouteLine.DrivingStep.CREATOR;
        } else if (readInt == 1) {
            obj = TransitRouteLine.TransitStep.CREATOR;
        } else if (readInt != 2) {
            if (readInt == 3) {
                obj = BikingRouteLine.BikingStep.CREATOR;
            }
            this.f7207f = parcel.readInt();
            this.f7208g = parcel.readInt();
        } else {
            obj = WalkingRouteLine.WalkingStep.CREATOR;
        }
        this.f7206e = parcel.createTypedArrayList(obj);
        this.f7207f = parcel.readInt();
        this.f7208g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.f7206e;
    }

    public int getDistance() {
        return this.f7207f;
    }

    public int getDuration() {
        return this.f7208g;
    }

    public RouteNode getStarting() {
        return this.f7203b;
    }

    public RouteNode getTerminal() {
        return this.f7204c;
    }

    public String getTitle() {
        return this.f7205d;
    }

    public TYPE getType() {
        return this.f7202a;
    }

    public void setDistance(int i2) {
        this.f7207f = i2;
    }

    public void setDuration(int i2) {
        this.f7208g = i2;
    }

    public void setStarting(RouteNode routeNode) {
        this.f7203b = routeNode;
    }

    public void setSteps(List<T> list) {
        this.f7206e = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.f7204c = routeNode;
    }

    public void setTitle(String str) {
        this.f7205d = str;
    }

    public void setType(TYPE type) {
        this.f7202a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        TYPE type = this.f7202a;
        parcel.writeInt(type != null ? type.a() : 10);
        parcel.writeValue(this.f7203b);
        parcel.writeValue(this.f7204c);
        parcel.writeString(this.f7205d);
        if (this.f7202a != null) {
            parcel.writeTypedList(this.f7206e);
        }
        parcel.writeInt(this.f7207f);
        parcel.writeInt(this.f7208g);
    }
}
