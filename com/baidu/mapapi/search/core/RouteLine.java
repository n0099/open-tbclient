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
    public TYPE a;
    public RouteNode b;
    public RouteNode c;
    public String d;
    public List<T> e;
    public int f;
    public int g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteLine() {
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
        return this.b;
    }

    public RouteNode getTerminal() {
        return this.c;
    }

    public String getTitle() {
        return this.d;
    }

    public TYPE getType() {
        return this.a;
    }

    /* loaded from: classes2.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        
        public int a;

        TYPE(int i) {
            this.a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.a;
        }
    }

    public RouteLine(Parcel parcel) {
        int readInt = parcel.readInt();
        this.b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.d = parcel.readString();
        if (readInt != 0) {
            if (readInt != 1) {
                if (readInt != 2) {
                    if (readInt == 3) {
                        this.e = parcel.createTypedArrayList(BikingRouteLine.BikingStep.CREATOR);
                    }
                } else {
                    this.e = parcel.createTypedArrayList(WalkingRouteLine.WalkingStep.CREATOR);
                }
            } else {
                this.e = parcel.createTypedArrayList(TransitRouteLine.TransitStep.CREATOR);
            }
        } else {
            this.e = parcel.createTypedArrayList(DrivingRouteLine.DrivingStep.CREATOR);
        }
        this.f = parcel.readInt();
        this.g = parcel.readInt();
    }

    public void setDistance(int i) {
        this.f = i;
    }

    public void setDuration(int i) {
        this.g = i;
    }

    public void setStarting(RouteNode routeNode) {
        this.b = routeNode;
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

    public void setType(TYPE type) {
        this.a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TYPE type = this.a;
        if (type != null) {
            parcel.writeInt(type.a());
        } else {
            parcel.writeInt(10);
        }
        parcel.writeValue(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        if (this.a != null) {
            parcel.writeTypedList(this.e);
        }
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }
}
