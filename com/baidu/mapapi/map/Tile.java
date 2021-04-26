package com.baidu.mapapi.map;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class Tile {
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i2, int i3, byte[] bArr) {
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("image_width", this.width);
        bundle.putInt("image_height", this.height);
        bundle.putByteArray("image_data", this.data);
        return bundle;
    }
}
