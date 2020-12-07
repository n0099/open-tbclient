package com.baidu.helios.bridge.multiprocess;

import android.database.AbstractCursor;
import android.os.Bundle;
/* loaded from: classes14.dex */
public class d extends AbstractCursor {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f1793a;

    public d(Bundle bundle) {
        this.f1793a = bundle;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return new String[0];
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return 0.0d;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f1793a;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        return 0L;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return (short) 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        return null;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return false;
    }
}
