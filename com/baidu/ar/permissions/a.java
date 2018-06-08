package com.baidu.ar.permissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private final Map<Integer, b> a = new HashMap();
    private Fragment b;

    public a(Fragment fragment) {
        this.b = fragment;
    }

    private void a(String[] strArr, String[] strArr2, boolean[] zArr, c cVar) {
        int a = d.a();
        this.a.put(Integer.valueOf(a), new b(strArr, zArr, strArr2, cVar));
        this.b.requestPermissions(strArr2, a);
    }

    private void b(String str, final PermissionAction permissionAction) {
        String[] strArr = {str};
        a(strArr, strArr, new boolean[]{false}, new c() { // from class: com.baidu.ar.permissions.a.1
            @Override // com.baidu.ar.permissions.c
            public void a(String[] strArr2, boolean[] zArr) {
                if (zArr[0]) {
                    d.a(permissionAction);
                } else {
                    d.b(permissionAction);
                }
            }
        });
    }

    public void a(int i, String[] strArr, int[] iArr) {
        b remove = this.a.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.a(strArr, iArr);
        }
    }

    @TargetApi(23)
    public void a(String str, PermissionAction permissionAction) {
        if (Build.VERSION.SDK_INT < 23) {
            d.a(permissionAction);
        } else if (this.b.getActivity().checkSelfPermission(str) == 0) {
            d.a(permissionAction);
        } else if (d.a((Activity) this.b.getActivity(), str)) {
            b(str, permissionAction);
        } else {
            d.b(permissionAction);
        }
    }

    public void a(String[] strArr, c cVar) {
        if (Build.VERSION.SDK_INT < 23) {
            d.a(cVar, strArr);
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            boolean z = this.b.getActivity().checkSelfPermission(str) == 0;
            if (!z && d.a((Activity) this.b.getActivity(), str)) {
                arrayList.add(str);
            }
            zArr[i] = z;
        }
        if (arrayList.size() != 0) {
            a(strArr, (String[]) arrayList.toArray(new String[arrayList.size()]), zArr, cVar);
        } else if (cVar != null) {
            cVar.a(strArr, zArr);
        }
    }
}
