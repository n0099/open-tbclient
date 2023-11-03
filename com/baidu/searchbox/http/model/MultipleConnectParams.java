package com.baidu.searchbox.http.model;

import java.util.List;
/* loaded from: classes4.dex */
public class MultipleConnectParams {
    public List<Integer> fromList;
    public int maxMultiConnectNum;
    public boolean multiConnectABSwitch;
    public int multiConnectDelayInMsMobile;
    public int multiConnectDelayInMsWifi;
    public boolean multiConnectEnabledGlobal;

    public int getMaxMultiConnectNum() {
        return this.maxMultiConnectNum;
    }

    public int getMultiConnectDelayInMsMobile() {
        return this.multiConnectDelayInMsMobile;
    }

    public int getMultiConnectDelayInMsWifi() {
        return this.multiConnectDelayInMsWifi;
    }

    public List<Integer> getMultiConnectFromList() {
        return this.fromList;
    }

    public boolean isMultiConnectABSwitch() {
        return this.multiConnectABSwitch;
    }

    public boolean isMultiConnectEnabledGlobal() {
        return this.multiConnectEnabledGlobal;
    }

    public MultipleConnectParams maxMultiConnectNum(int i) {
        this.maxMultiConnectNum = i;
        return this;
    }

    public MultipleConnectParams multiConnectABSwitch(boolean z) {
        this.multiConnectABSwitch = z;
        return this;
    }

    public MultipleConnectParams multiConnectDelayInMsMobile(int i) {
        this.multiConnectDelayInMsMobile = i;
        return this;
    }

    public MultipleConnectParams multiConnectDelayInMsWifi(int i) {
        this.multiConnectDelayInMsWifi = i;
        return this;
    }

    public MultipleConnectParams multiConnectEnabledGlobal(boolean z) {
        this.multiConnectEnabledGlobal = z;
        return this;
    }

    public MultipleConnectParams multiConnectFromList(List<Integer> list) {
        this.fromList = list;
        return this;
    }
}
