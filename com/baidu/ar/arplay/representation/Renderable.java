package com.baidu.ar.arplay.representation;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class Renderable implements Serializable {
    public static final long serialVersionUID = 6701586807666461858L;
    public boolean dirty = true;
    public ReentrantLock lock = new ReentrantLock();

    public boolean dirty() {
        return this.dirty;
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    public void setClean() {
        this.dirty = false;
    }

    public void setDirty() {
        this.dirty = true;
    }
}
