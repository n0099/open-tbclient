package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends Activity {
    final Handler a;
    final l b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    r k;
    w l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w a(int i, boolean z, boolean z2) {
        if (this.k == null) {
            this.k = new r();
        }
        w wVar = (w) this.k.a(i);
        if (wVar != null) {
            wVar.a(this);
            return wVar;
        } else if (z2) {
            w wVar2 = new w(this, z);
            this.k.b(i, wVar2);
            return wVar2;
        } else {
            return wVar;
        }
    }

    public void a() {
        if (this.b.c()) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        w wVar;
        if (this.k == null || (wVar = (w) this.k.a(i)) == null || wVar.f) {
            return;
        }
        wVar.h();
        this.k.c(i);
    }

    public void a(Fragment fragment) {
    }

    void a(boolean z) {
        if (this.f) {
            return;
        }
        this.f = true;
        this.g = z;
        this.a.removeMessages(1);
        d();
    }

    public Object b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (Build.VERSION.SDK_INT >= 11) {
            a.a(this);
        } else {
            this.h = true;
        }
    }

    void d() {
        if (this.j) {
            this.j = false;
            if (this.l != null) {
                if (this.g) {
                    this.l.d();
                } else {
                    this.l.c();
                }
            }
        }
        this.b.p();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        if (this.b.f == null || i4 < 0 || i4 >= this.b.f.size()) {
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
            return;
        }
        Fragment fragment = (Fragment) this.b.f.get(i4);
        if (fragment == null) {
            Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
        }
        fragment.a(65535 & i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.b.a(this);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            this.k = iVar.e;
        }
        if (bundle != null) {
            this.b.a(bundle.getParcelable("android:support:fragments"), iVar != null ? iVar.d : null);
        }
        this.b.j();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.b.a(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT >= 11) {
                return onCreatePanelMenu;
            }
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x005c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x006e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.support.v4.app.Fragment] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.support.v4.app.Fragment, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.support.v4.app.l] */
    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            int id = 0 != 0 ? r1.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            r1 = resourceId != -1 ? this.b.a(resourceId) : 0;
            if (r1 == 0 && string != null) {
                r1 = this.b.a(string);
            }
            if (r1 == 0 && id != -1) {
                r1 = this.b.a(id);
            }
            if (l.a) {
                Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + ((Object) r1));
            }
            if (r1 == 0) {
                Fragment a = Fragment.a(this, attributeValue);
                a.w = true;
                a.C = resourceId != 0 ? resourceId : id;
                a.D = id;
                a.E = string;
                a.x = true;
                a.A = this.b;
                a.a(this, attributeSet, a.l);
                this.b.a(a, true);
                fragment = a;
            } else if (r1.x) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            } else {
                r1.x = true;
                if (!r1.I) {
                    r1.a(this, attributeSet, r1.l);
                }
                this.b.b(r1);
                fragment = r1;
            }
            if (fragment.O == null) {
                throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
            }
            if (resourceId != 0) {
                fragment.O.setId(resourceId);
            }
            if (fragment.O.getTag() == null) {
                fragment.O.setTag(string);
            }
            return fragment.O;
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.b.q();
        if (this.l != null) {
            this.l.h();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT < 5 && i == 4 && keyEvent.getRepeatCount() == 0) {
            a();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.b.r();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.b.a(menuItem);
            case 6:
                return this.b.b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.b.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            this.b.m();
        }
        this.b.n();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        this.b.m();
        this.b.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.h) {
            this.h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return (super.onPreparePanel(i, view, menu) || this.b.a(menu)) && menu.hasVisibleItems();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.e();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.e) {
            a(true);
        }
        Object b = b();
        ArrayList g = this.b.g();
        boolean z2 = false;
        if (this.k != null) {
            int a = this.k.a() - 1;
            while (a >= 0) {
                w wVar = (w) this.k.f(a);
                if (wVar.f) {
                    z = true;
                } else {
                    wVar.h();
                    this.k.d(a);
                    z = z2;
                }
                a--;
                z2 = z;
            }
        }
        if (g == null && !z2 && b == null) {
            return null;
        }
        i iVar = new i();
        iVar.a = null;
        iVar.b = b;
        iVar.c = null;
        iVar.d = g;
        iVar.e = this.k;
        return iVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.b.h();
        if (h != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.e = false;
        this.f = false;
        this.a.removeMessages(1);
        if (!this.c) {
            this.c = true;
            this.b.k();
        }
        this.b.i();
        this.b.e();
        if (!this.j) {
            this.j = true;
            if (this.l != null) {
                this.l.b();
            } else if (!this.i) {
                this.l = a(-1, this.j, false);
            }
            this.i = true;
        }
        this.b.l();
        if (this.k != null) {
            for (int a = this.k.a() - 1; a >= 0; a--) {
                w wVar = (w) this.k.f(a);
                wVar.e();
                wVar.g();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.e = true;
        this.a.sendEmptyMessage(1);
        this.b.o();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }
}
