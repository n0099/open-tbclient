package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f11319a;

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        this.f11319a = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.f11319a = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (activityInfoArr[i] != null) {
                b bVar = new b();
                bVar.f11327h = activityInfoArr[i].configChanges;
                bVar.f11325f = activityInfoArr[i].flags;
                bVar.l = activityInfoArr[i].labelRes;
                bVar.f11321b = activityInfoArr[i].launchMode;
                if (activityInfoArr[i].nonLocalizedLabel != null) {
                    bVar.m = activityInfoArr[i].nonLocalizedLabel.toString();
                }
                bVar.j = activityInfoArr[i].name;
                bVar.k = activityInfoArr[i].packageName;
                bVar.f11322c = activityInfoArr[i].permission;
                bVar.f11326g = activityInfoArr[i].screenOrientation;
                bVar.i = activityInfoArr[i].softInputMode;
                bVar.f11324e = activityInfoArr[i].targetActivity;
                bVar.f11323d = activityInfoArr[i].taskAffinity;
                bVar.f11320a = activityInfoArr[i].theme;
                this.f11319a.add(bVar);
            }
        }
    }

    public final byte[] a() {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(this.f11319a);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                        com.baidu.sofire.g.d.a();
                    }
                    return byteArray;
                } catch (IOException unused2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused3) {
                            com.baidu.sofire.g.d.a();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused4) {
                            com.baidu.sofire.g.d.a();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                objectOutputStream = null;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
            }
        } catch (IOException unused6) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th4) {
            objectOutputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static ArrayList<b> a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    ArrayList<b> arrayList = (ArrayList) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                        com.baidu.sofire.g.d.a();
                    }
                    return arrayList;
                } catch (Throwable unused2) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused3) {
                            com.baidu.sofire.g.d.a();
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                objectInputStream = null;
            }
        } catch (Throwable unused5) {
            objectInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
