package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.RestrictTo;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo
/* loaded from: classes2.dex */
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] GH = {Context.class};
    static final Class<?>[] GI = GH;
    final Object[] GJ;
    final Object[] GK;
    private Object GL;
    Context mContext;

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        this.GJ = new Object[]{context};
        this.GK = this.GJ;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        switch(r3) {
            case 1: goto L56;
            case 2: goto L13;
            case 3: goto L30;
            default: goto L10;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        r9 = r3;
        r3 = r11.next();
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r5 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        r3 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
        if (r3.equals("group") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
        r7.a(r12);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
        if (r3.equals("item") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        r7.b(r12);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
        if (r3.equals("menu") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
        a(r11, r12, r7.eJ());
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
        r2 = r3;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
        r3 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
        if (r5 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
        if (r3.equals(r2) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
        r2 = null;
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        if (r3.equals("group") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
        r7.eH();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
        if (r3.equals("item") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if (r7.eK() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r7.Hk == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c2, code lost:
        if (r7.Hk.hasSubMenu() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
        r7.eJ();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ca, code lost:
        r7.eI();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d7, code lost:
        if (r3.equals("menu") == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
        r0 = true;
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e5, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        r2 = null;
        r5 = false;
        r3 = r0;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0 != false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
    }

    Object eG() {
        if (this.GL == null) {
            this.GL = aj(this.mContext);
        }
        return this.GL;
    }

    private Object aj(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return aj(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] GM = {MenuItem.class};
        private Object GL;
        private Method mMethod;

        public a(Object obj, String str) {
            this.GL = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, GM);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.GL, menuItem)).booleanValue();
                }
                this.mMethod.invoke(this.GL, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        private Menu GN;
        private int GO;
        private int GP;
        private int GQ;
        private boolean GR;
        private boolean GT;
        private boolean GU;
        private int GV;
        private CharSequence GW;
        private CharSequence GX;
        private int GY;
        private char GZ;
        private char Ha;
        private int Hb;
        private boolean Hc;
        private boolean Hd;
        private boolean He;
        private int Hf;
        private int Hg;
        private String Hh;
        private String Hi;
        private String Hj;
        ActionProvider Hk;
        private int groupId;
        private int itemId;

        public b(Menu menu) {
            this.GN = menu;
            eH();
        }

        public void eH() {
            this.groupId = 0;
            this.GO = 0;
            this.GP = 0;
            this.GQ = 0;
            this.GR = true;
            this.GT = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.groupId = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.GO = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.GP = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.GQ = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.GR = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.GT = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.itemId = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.GV = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.GO) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.GP) & SupportMenu.USER_MASK);
            this.GW = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.GX = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.GY = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.GZ = B(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.Ha = B(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.Hb = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.Hb = this.GQ;
            }
            this.Hc = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.Hd = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.GR);
            this.He = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.GT);
            this.Hf = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.Hj = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.Hg = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.Hh = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.Hi = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.Hi != null;
            if (z && this.Hg == 0 && this.Hh == null) {
                this.Hk = (ActionProvider) newInstance(this.Hi, SupportMenuInflater.GI, SupportMenuInflater.this.GK);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.Hk = null;
            }
            obtainStyledAttributes.recycle();
            this.GU = false;
        }

        private char B(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.Hc).setVisible(this.Hd).setEnabled(this.He).setCheckable(this.Hb >= 1).setTitleCondensed(this.GX).setIcon(this.GY).setAlphabeticShortcut(this.GZ).setNumericShortcut(this.Ha);
            if (this.Hf >= 0) {
                MenuItemCompat.setShowAsAction(menuItem, this.Hf);
            }
            if (this.Hj != null) {
                if (SupportMenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(SupportMenuInflater.this.eG(), this.Hj));
            }
            if (menuItem instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.Hb >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            if (this.Hh != null) {
                MenuItemCompat.setActionView(menuItem, (View) newInstance(this.Hh, SupportMenuInflater.GH, SupportMenuInflater.this.GJ));
            } else {
                z = false;
            }
            if (this.Hg > 0) {
                if (!z) {
                    MenuItemCompat.setActionView(menuItem, this.Hg);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.Hk != null) {
                MenuItemCompat.setActionProvider(menuItem, this.Hk);
            }
        }

        public void eI() {
            this.GU = true;
            a(this.GN.add(this.groupId, this.itemId, this.GV, this.GW));
        }

        public SubMenu eJ() {
            this.GU = true;
            SubMenu addSubMenu = this.GN.addSubMenu(this.groupId, this.itemId, this.GV, this.GW);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean eK() {
            return this.GU;
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
