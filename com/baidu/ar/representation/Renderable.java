package com.baidu.ar.representation;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class Renderable implements Serializable {
    private static final long serialVersionUID = 6701586807666461858L;
    protected boolean dirty = true;
    protected ReentrantLock lock = new ReentrantLock();
}
