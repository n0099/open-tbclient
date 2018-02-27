package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo
/* loaded from: classes2.dex */
public final class AppCompatDrawableManager {
    private static AppCompatDrawableManager ME;
    private WeakHashMap<Context, SparseArray<ColorStateList>> MN;
    private ArrayMap<String, c> MO;
    private SparseArray<String> MP;
    private final Object MQ = new Object();
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> MR = new WeakHashMap<>(0);
    private TypedValue MS;
    private boolean MT;
    private static final PorterDuff.Mode MD = PorterDuff.Mode.SRC_IN;
    private static final b MF = new b(6);
    private static final int[] MG = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] MH = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] MI = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] MJ = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] MK = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    private static final int[] MM = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static AppCompatDrawableManager get() {
        if (ME == null) {
            ME = new AppCompatDrawableManager();
            a(ME);
        }
        return ME;
    }

    private static void a(AppCompatDrawableManager appCompatDrawableManager) {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            appCompatDrawableManager.a("vector", new d());
            if (i >= 11) {
                appCompatDrawableManager.a("animated-vector", new a());
            }
        }
    }

    public Drawable getDrawable(Context context, int i) {
        return b(context, i, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable b(Context context, int i, boolean z) {
        X(context);
        Drawable j = j(context, i);
        if (j == null) {
            j = i(context, i);
        }
        if (j == null) {
            j = ContextCompat.getDrawable(context, i);
        }
        if (j != null) {
            j = a(context, i, z, j);
        }
        if (j != null) {
            DrawableUtils.g(j);
        }
        return j;
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this.MQ) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.MR.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable i(Context context, int i) {
        if (this.MS == null) {
            this.MS = new TypedValue();
        }
        TypedValue typedValue = this.MS;
        context.getResources().getValue(i, typedValue, true);
        long a2 = a(typedValue);
        Drawable e = e(context, a2);
        if (e == null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                e = new LayerDrawable(new Drawable[]{getDrawable(context, R.drawable.abc_cab_background_internal_bg), getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (e != null) {
                e.setChangingConfigurations(typedValue.changingConfigurations);
                a(context, a2, e);
            }
        }
        return e;
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList k = k(context, i);
        if (k != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, k);
            PorterDuff.Mode bg = bg(i);
            if (bg != null) {
                DrawableCompat.setTintMode(wrap, bg);
                return wrap;
            }
            return wrap;
        } else if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), s.n(context, R.attr.colorControlNormal), MD);
            a(layerDrawable.findDrawableByLayerId(16908303), s.n(context, R.attr.colorControlNormal), MD);
            a(layerDrawable.findDrawableByLayerId(16908301), s.n(context, R.attr.colorControlActivated), MD);
            return drawable;
        } else if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), s.p(context, R.attr.colorControlNormal), MD);
            a(layerDrawable2.findDrawableByLayerId(16908303), s.n(context, R.attr.colorControlActivated), MD);
            a(layerDrawable2.findDrawableByLayerId(16908301), s.n(context, R.attr.colorControlActivated), MD);
            return drawable;
        } else if (!a(context, i, drawable) && z) {
            return null;
        } else {
            return drawable;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Drawable j(Context context, int i) {
        Drawable drawable;
        XmlResourceParser xml;
        AttributeSet asAttributeSet;
        int next;
        if (this.MO == null || this.MO.isEmpty()) {
            return null;
        }
        if (this.MP != null) {
            String str = this.MP.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.MO.get(str) == null)) {
                return null;
            }
        } else {
            this.MP = new SparseArray<>();
        }
        if (this.MS == null) {
            this.MS = new TypedValue();
        }
        TypedValue typedValue = this.MS;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a2 = a(typedValue);
        Drawable e = e(context, a2);
        if (e != null) {
            return e;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                xml = resources.getXml(i);
                asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManager", "Exception while inflating drawable", e2);
            }
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            String name = xml.getName();
            this.MP.append(i, name);
            c cVar = this.MO.get(name);
            if (cVar != null) {
                e = cVar.a(context, xml, asAttributeSet, context.getTheme());
            }
            if (e != null) {
                e.setChangingConfigurations(typedValue.changingConfigurations);
                if (a(context, a2, e)) {
                }
            }
            drawable = e;
            if (drawable != null) {
                this.MP.append(i, "appcompat_skip_skip");
                return drawable;
            }
            return drawable;
        }
        drawable = e;
        if (drawable != null) {
        }
    }

    private Drawable e(Context context, long j) {
        synchronized (this.MQ) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.MR.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
            if (weakReference != null) {
                Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.delete(j);
            }
            return null;
        }
    }

    private boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.MQ) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.MR.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray<>();
                    this.MR.put(context, longSparseArray);
                }
                longSparseArray.put(j, new WeakReference<>(constantState));
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        Drawable j = j(context, i);
        if (j == null) {
            j = vectorEnabledTintResources.ci(i);
        }
        if (j != null) {
            return a(context, i, false, j);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        int i3;
        PorterDuff.Mode mode;
        boolean z;
        PorterDuff.Mode mode2 = MD;
        if (b(MG, i)) {
            i3 = R.attr.colorControlNormal;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (b(MI, i)) {
            i3 = R.attr.colorControlActivated;
            mode = mode2;
            z = true;
            i2 = -1;
        } else if (b(MJ, i)) {
            z = true;
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = 16842801;
            i2 = -1;
        } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
            i3 = 16842800;
            i2 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == R.drawable.abc_dialog_material_background) {
            i3 = 16842801;
            mode = mode2;
            z = true;
            i2 = -1;
        } else {
            i2 = -1;
            i3 = 0;
            mode = mode2;
            z = false;
        }
        if (z) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(getPorterDuffColorFilter(s.n(context, i3), mode));
            if (i2 != -1) {
                drawable.setAlpha(i2);
                return true;
            }
            return true;
        }
        return false;
    }

    private void a(String str, c cVar) {
        if (this.MO == null) {
            this.MO = new ArrayMap<>();
        }
        this.MO.put(str, cVar);
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode bg(int i) {
        if (i != R.drawable.abc_switch_thumb_material) {
            return null;
        }
        return PorterDuff.Mode.MULTIPLY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList k(Context context, int i) {
        return b(context, i, (ColorStateList) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b(Context context, int i, ColorStateList colorStateList) {
        boolean z = colorStateList == null;
        ColorStateList l = z ? l(context, i) : null;
        if (l == null) {
            if (i == R.drawable.abc_edit_text_material) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_thumb);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                l = a(context, colorStateList);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                l = b(context, colorStateList);
            } else if (i == R.drawable.abc_btn_colored_material) {
                l = c(context, colorStateList);
            } else if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
            } else if (b(MH, i)) {
                l = s.o(context, R.attr.colorControlNormal);
            } else if (b(MK, i)) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
            } else if (b(MM, i)) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
            } else if (i == R.drawable.abc_seekbar_thumb_material) {
                l = AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            if (z && l != null) {
                c(context, i, l);
            }
        }
        return l;
    }

    private ColorStateList l(Context context, int i) {
        SparseArray<ColorStateList> sparseArray;
        if (this.MN != null && (sparseArray = this.MN.get(context)) != null) {
            return sparseArray.get(i);
        }
        return null;
    }

    private void c(Context context, int i, ColorStateList colorStateList) {
        if (this.MN == null) {
            this.MN = new WeakHashMap<>();
        }
        SparseArray<ColorStateList> sparseArray = this.MN.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.MN.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList a(Context context, ColorStateList colorStateList) {
        return d(context, s.n(context, R.attr.colorButtonNormal), colorStateList);
    }

    private ColorStateList b(Context context, ColorStateList colorStateList) {
        return d(context, 0, null);
    }

    private ColorStateList c(Context context, ColorStateList colorStateList) {
        return d(context, s.n(context, R.attr.colorAccent), colorStateList);
    }

    private ColorStateList d(Context context, int i, ColorStateList colorStateList) {
        int[][] iArr = new int[4];
        int[] iArr2 = new int[4];
        int n = s.n(context, R.attr.colorControlHighlight);
        int p = s.p(context, R.attr.colorButtonNormal);
        iArr[0] = s.lg;
        if (colorStateList != null) {
            p = colorStateList.getColorForState(iArr[0], 0);
        }
        iArr2[0] = p;
        iArr[1] = s.PRESSED_STATE_SET;
        iArr2[1] = ColorUtils.compositeColors(n, colorStateList == null ? i : colorStateList.getColorForState(iArr[1], 0));
        iArr[2] = s.FOCUSED_STATE_SET;
        iArr2[2] = ColorUtils.compositeColors(n, colorStateList == null ? i : colorStateList.getColorForState(iArr[2], 0));
        iArr[3] = s.EMPTY_STATE_SET;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(iArr[3], 0);
        }
        iArr2[3] = i;
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends LruCache<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(d(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(d(i, mode)), porterDuffColorFilter);
        }

        private static int d(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, t tVar, int[] iArr) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (tVar.Xe || tVar.Xd) {
            drawable.setColorFilter(a(tVar.Xe ? tVar.Xc : null, tVar.Xd ? tVar.uo : MD, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter c2 = MF.c(i, mode);
        if (c2 == null) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            MF.a(i, mode, porterDuffColorFilter);
            return porterDuffColorFilter;
        }
        return c2;
    }

    private static void a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = MD;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(i, mode));
    }

    private void X(Context context) {
        if (!this.MT) {
            this.MT = true;
            Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
            if (drawable == null || !e(drawable)) {
                this.MT = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static boolean e(Drawable drawable) {
        return (drawable instanceof android.support.a.a.f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements c {
        d() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.a.a.f.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements c {
        a() {
        }

        @Override // android.support.v7.widget.AppCompatDrawableManager.c
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.a.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }
}
