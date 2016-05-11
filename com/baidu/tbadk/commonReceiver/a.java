package com.baidu.tbadk.commonReceiver;

import java.util.Observable;
/* loaded from: classes.dex */
public class a extends Observable {
    private long album_id;

    public void m(long j) {
        this.album_id = j;
        setChanged();
        notifyObservers();
    }

    public long nD() {
        return this.album_id;
    }
}
