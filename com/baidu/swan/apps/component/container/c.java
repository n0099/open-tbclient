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
    com.baidu.swan.apps.view.b.a bVB;
    @NonNull
    ArrayMap<String, com.baidu.swan.apps.component.b.a> bVC = new ArrayMap<>();
    @NonNull
    ArrayMap<String, List<com.baidu.swan.apps.component.b.a>> bVD = new ArrayMap<>();

    public c(@NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.bVB = aVar;
    }

    @UiThread
    public boolean e(com.baidu.swan.apps.component.b.a aVar) {
        boolean a;
        if (aVar == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Wp = aVar.Wp();
        String str = Wp.bUs;
        String str2 = Wp.bUt;
        String name = aVar.getName();
        SwanAppComponentContainerView Wr = aVar.Wr();
        if (Wr == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert " + name + " with a null container view");
            return false;
        }
        if (this.bVC.containsKey(str2)) {
            com.baidu.swan.apps.console.c.w("Component-Container", name + " repeat insert: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert " + name + " with a empty component id");
            return false;
        } else if (Wp.bUx == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert " + name + " with a null position");
            return false;
        } else {
            if (!Wp.bUx.isValid()) {
                com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert " + name + " with a invalid position: " + (Wp.bUx == null ? "null" : Wp.bUx));
                Wp.bUx = new com.baidu.swan.apps.model.a.a.a();
            }
            if (!b.f(Wp)) {
                if (TextUtils.isEmpty(Wp.bUv)) {
                    a = this.bVB.a(Wr, Wp.bUx);
                } else {
                    SwanAppComponentContainerView iQ = iQ(Wp.bUv);
                    if (iQ == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "insert " + name + " to parent with a null parent container view");
                        return false;
                    }
                    if (iQ.indexOfChild(Wr) >= 0) {
                        com.baidu.swan.apps.component.e.a.aU("Component-Container", name + " repeat insert view!");
                        iQ.removeView(Wr);
                    }
                    iQ.addView(Wr, Wp.Wv());
                    a = true;
                }
            } else {
                a = b.a(this, Wp, Wr);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aU("Component-Container", name + " insertComponentForScroll fail");
                }
            }
            if (a) {
                this.bVC.put(Wp.bUt, aVar);
                if (aVar.eG(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bVD.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.bVD.put(str, list);
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
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "update component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Wp = aVar.Wp();
        String name = aVar.getName();
        SwanAppComponentContainerView Wr = aVar.Wr();
        if (Wr == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "update " + name + " with a null container view");
            return false;
        }
        if (!this.bVC.containsKey(Wp.bUt)) {
            com.baidu.swan.apps.console.c.e("Component-Container", "don't insert" + name);
        }
        if (aVar instanceof com.baidu.swan.apps.component.components.e.c.a) {
            if (bVar.eK(7)) {
                boolean a = b.a(this, aVar, Wp, Wr, bVar);
                if (!a) {
                    com.baidu.swan.apps.component.e.a.aU("Component-Container", name + " perform scroll type update fail");
                    return a;
                }
                return a;
            } else if (bVar.eK(8)) {
                b.b(this, aVar, Wp, Wr, bVar);
            }
        }
        if (bVar.eK(3) && !a(aVar, Wr, Wp)) {
            com.baidu.swan.apps.console.c.e("Component-Container", name + " perform position update fail");
            return false;
        }
        if (aVar instanceof com.baidu.swan.apps.component.a.d.a) {
            com.baidu.swan.apps.component.a.d.a aVar2 = (com.baidu.swan.apps.component.a.d.a) aVar;
            if (aVar2.Wi()) {
                if (DEBUG) {
                    Log.d("Component-Container", name + "perform position update with animation");
                }
                if (!aVar2.Wj()) {
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
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "remove component with a null component");
            return false;
        }
        com.baidu.swan.apps.component.b.b Wp = aVar.Wp();
        String str = Wp.bUs;
        String str2 = Wp.bUt;
        String name = aVar.getName();
        SwanAppComponentContainerView Wr = aVar.Wr();
        if (Wr == null) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "remove " + name + " with a null container view");
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "remove " + name + " with a empty component id");
            return false;
        } else {
            if (!b.f(Wp)) {
                if (TextUtils.isEmpty(Wp.bUv)) {
                    c = this.bVB.av(Wr);
                } else {
                    SwanAppComponentContainerView iQ = iQ(Wp.bUv);
                    if (iQ == null) {
                        com.baidu.swan.apps.console.c.e("Component-Container", "remove " + name + " to parent with a null parent container view");
                    } else if (iQ == Wr.getParent()) {
                        iQ.removeView(Wr);
                        z = true;
                    } else {
                        com.baidu.swan.apps.component.e.a.aU("Component-Container", "remove " + name + " to parent with a illegal parent view");
                    }
                    c = z;
                }
            } else {
                c = b.c(this, Wp, Wr);
                if (!c) {
                    com.baidu.swan.apps.component.e.a.aU("Component-Container", name + " removeComponentForScroll fail");
                }
            }
            if (c || aVar.eG(1)) {
                this.bVC.remove(str2);
                if (aVar.eG(2)) {
                    com.baidu.swan.apps.console.c.w("Component-Container", name + " remove with FLAG_CAN_NO_COMPONENT_ID");
                    List<com.baidu.swan.apps.component.b.a> list = this.bVD.get(str);
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
        for (Map.Entry<String, com.baidu.swan.apps.component.b.a> entry : this.bVC.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
        this.bVC.clear();
        this.bVD.clear();
    }

    private boolean a(@NonNull com.baidu.swan.apps.component.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull com.baidu.swan.apps.component.b.b bVar) {
        String name = aVar.getName();
        if (DEBUG) {
            Log.d("Component-Container", name + " perform position update");
        }
        if (bVar.bUx == null || !bVar.bUx.isValid()) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "insert " + name + " with a invalid position: " + (bVar.bUx == null ? "null" : bVar.bUx));
            return false;
        }
        if (b.f(bVar) && !b.b(this, bVar, swanAppComponentContainerView)) {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", name + " performPositionUpdateForScroll fail");
        }
        String str = bVar.bUv;
        if (TextUtils.isEmpty(str)) {
            return this.bVB.b(swanAppComponentContainerView, bVar.bUx);
        }
        SwanAppComponentContainerView iQ = iQ(str);
        if (iQ == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "update " + name + " to parent with a null parent container view");
            return false;
        } else if (swanAppComponentContainerView.getParent() == iQ) {
            iQ.updateViewLayout(swanAppComponentContainerView, bVar.Wv());
            return true;
        } else {
            com.baidu.swan.apps.component.e.a.aU("Component-Container", "update " + name + " to parent with a illegal parent view");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SwanAppComponentContainerView iQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.swan.apps.component.b.a aVar = this.bVC.get(str);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("Component-Container", "getContainerView : get a null  component#" + str);
            return null;
        }
        return aVar.Wr();
    }
}
