package com.baidu.swan.apps.component.container;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public final class c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    com.baidu.swan.apps.view.b.a bjv;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bjw = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bjx = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bjv = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KI = aVar.KI();
        String str = KI.bil;
        String str2 = KI.bim;
        String name = aVar.getName();
        SwanAppComponentContainerView KK = aVar.KK();
        if (KK == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bjw.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (KI.bir == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!KI.bir.isValid()) {
                com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a invalid position: " + (KI.bir == null ? "null" : KI.bir));
                KI.bir = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(KI)) {
                if (TextUtils.isEmpty(KI.bip)) {
                    a = this.bjv.a(KK, KI.bir);
                } else {
                    SwanAppComponentContainerView gw = gw(KI.bip);
                    if (gw == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (gw.indexOfChild(KK) >= 0) {
                        com.baidu.swan.apps.component.e.a.au("Component-Container", name + " repeat insert view!");
                        gw.removeView(KK);
                    }
                    gw.addView(KK, KI.KO());
                    a = true;
                }
            } else {
                a = b.a(this, KI, KK);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bjw.put(KI.bim, aVar);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjx.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bjx.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return a;
        }
    }

    @UiThread
    public boolean a(com.baidu.swan.apps.component.b.a aVar, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KI = aVar.KI();
        String name = aVar.getName();
        SwanAppComponentContainerView KK = aVar.KK();
        if (KK == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bjw.containsKey(KI.bim)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.ej(7)) {
                boolean a = b.a(this, aVar, KI, KK, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.ej(8)) {
                b.b(this, aVar, KI, KK, bVar);
            }
        }
        if (bVar.ej(3) && !a(aVar, KK, KI)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.KB()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.KC()) {
                    com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update with animation fail");
                    return false;
                }
            }
        }
        return true;
    }

    @UiThread
    public boolean f(com.baidu.swan.apps.component.b.a aVar) {
        boolean c;
        boolean z = false;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b KI = aVar.KI();
        String str = KI.bil;
        String str2 = KI.bim;
        String name = aVar.getName();
        SwanAppComponentContainerView KK = aVar.KK();
        if (KK == null) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(KI)) {
                if (TextUtils.isEmpty(KI.bip)) {
                    c = this.bjv.au(KK);
                } else {
                    SwanAppComponentContainerView gw = gw(KI.bip);
                    if (gw == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (gw == KK.getParent()) {
                        gw.removeView(KK);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.au("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, KI, KK);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.au("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.ef(1)) {
                this.bjw.remove(str2);
                if (aVar.ef(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bjx.get(str);
                    if (list != null) {
                        list.remove(aVar);
                    }
                }
            }
            return c;
        }
    }

    public void onDestroy() {
        com.baidu.swan.apps.component.b.a value;
        if (DEBUG) {
            Log.d("Component-Container", "container destroy");
        }
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bjw.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bjw.clear();
        this.bjx.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bir == null || !bVar.bir.isValid()) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bir == null ? "null" : bVar.bir));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.au("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bip;
        if (TextUtils.isEmpty(str)) {
            return this.bjv.b(swanAppComponentContainerView, bVar.bir);
        }
        SwanAppComponentContainerView gw = gw(str);
        if (gw == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == gw) {
            gw.updateViewLayout(swanAppComponentContainerView, bVar.KO());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.au("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView gw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bjw.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.KK();
    }
}
