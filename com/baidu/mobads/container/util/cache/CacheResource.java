package com.baidu.mobads.container.util.cache;

import android.graphics.Bitmap;
import com.baidu.mobads.container.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes2.dex */
public class CacheResource<T> {
    public T resource;

    public CacheResource(T t) {
        this.resource = t;
    }

    public T get() {
        return this.resource;
    }

    public byte[] getByte() {
        T t = this.resource;
        if (t instanceof Bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.resource).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (t instanceof File) {
            return FileUtils.readFileToByteArray((File) t);
        } else {
            if (t instanceof byte[]) {
                return (byte[]) t;
            }
            return null;
        }
    }

    public Class<?> getResourceClass() {
        return this.resource.getClass();
    }

    public boolean isExpired(long j) {
        return (this.resource instanceof File) && System.currentTimeMillis() - ((File) this.resource).lastModified() > j;
    }

    public boolean recycle() {
        boolean delete;
        T t = this.resource;
        if (t instanceof Bitmap) {
            if (!((Bitmap) t).isRecycled()) {
                ((Bitmap) this.resource).recycle();
            }
        } else if (t instanceof File) {
            delete = ((File) t).delete();
            this.resource = null;
            return delete;
        }
        delete = true;
        this.resource = null;
        return delete;
    }

    public int size() {
        T t = this.resource;
        if (t instanceof Bitmap) {
            return ((Bitmap) t).getByteCount();
        }
        if (t instanceof File) {
            return (int) ((File) t).length();
        }
        if (t instanceof byte[]) {
            return ((byte[]) t).length;
        }
        return 1;
    }
}
