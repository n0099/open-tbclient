package com.baidu.live.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class SkinManager {
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NONE = 3;
    public static final int SKIN_TYPE_NORMAL = 0;
    private static String TYPE_ERROR = null;
    private static String mPluginPackage = null;
    private static Resources mPluginRes = null;
    private static Resources mSkinRes = null;
    private static final String nightSufix = "_1";
    private static String sPackagename;
    private static int sPacknameLength;

    /* loaded from: classes4.dex */
    public static final class ViewType {
        public static final int BUTTON = 3;
        public static final int CHECKBOX = 4;
        public static final int EDITTEXT = 2;
        public static final int TEXTVIEW = 1;
    }

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.live.tbadk.core.util.SkinManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Resources unused = SkinManager.mPluginRes = null;
            }
        });
        TYPE_ERROR = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
    }

    @Deprecated
    public static void setButtonTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void setTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_cp_bg_line_k));
            }
        }
    }

    @Deprecated
    public static void setBlueTextColor1(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_common_color_10213, 1);
        }
    }

    public static void setBlueTextColor2(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_common_color_10214, 1);
        }
    }

    public static void setGrayTextColor1(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_cp_cont_b, 1);
        }
    }

    public static void setGrayTextColor2(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_common_color_10005, 1);
        }
    }

    public static void setGrayTextColor3(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_common_color_10215, 1);
        }
    }

    public static void setBgColor(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(a.c.sdk_common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(a.c.sdk_common_color_10163));
            }
        }
    }

    public static void setFrsPBBgColor(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, a.e.sdk_common_bg);
        }
    }

    public static void setLoginBgColor(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(a.c.sdk_common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(a.c.sdk_common_color_10216));
            }
        }
    }

    public static void setTopBarTitleColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(a.c.sdk_cp_bg_line_d));
            }
        }
    }

    public static void setTopBarBgImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, a.e.sdk_titlebar_bg);
        }
    }

    public static void setSubPbBgHeadImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, a.e.sdk_bg_pb_list_top);
        }
    }

    public static void setSubPbBgFootImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, a.e.sdk_bg_pb_list_bottom);
        }
    }

    public static void setTopBarCommonButtonBgImage(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, a.e.sdk_title_comm);
        }
        setTopBarTitleColor(textView, i);
    }

    public static void setTopBarCommonHiliteButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, a.e.sdk_title_comm_hilite);
        }
        setTopBarTitleColor(textView, i);
    }

    public static void setTopBarCommonFinishButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, a.e.sdk_navi_done_text_bg);
        }
        setTopBarCommonFinishButtonText(textView, i);
    }

    public static void setTopBarCommonFinishButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_navi_done_text, 1);
        }
    }

    public static void setTopBarCommonOperateButton(TextView textView, int i) {
        setTopBarCommonOperateButtonText(textView, i);
    }

    public static void setTopBarCommonOperateButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_navi_op_text, 1);
        }
    }

    public static void setTopBarCommonDeleteButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, a.e.sdk_navi_del_text_bg);
        }
        setTopBarCommonDeleteButtonText(textView, i);
    }

    public static void setTopBarCommonDeleteButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, a.c.sdk_navi_del_text, 1);
        }
    }

    public static void setTopBarBackBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, a.e.sdk_icon_topbar_return_n);
        }
    }

    public static void setCommonTabBgImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, a.e.sdk_home_radio_button);
        }
    }

    public static void setTopBarRefrshBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, a.e.sdk_icon_refresh_n);
        }
    }

    public static void setTopBarSearchBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, a.e.sdk_icon_topbar_search_n);
        }
    }

    public static int getCommentTextColor(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(a.c.sdk_common_color_10004);
        }
        throw new IllegalArgumentException(TYPE_ERROR);
    }

    public static int getSecondCommentTextColor(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(a.c.sdk_common_color_10217);
        }
        throw new IllegalArgumentException(TYPE_ERROR);
    }

    public static int getThirdCommentTextColor(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(a.c.sdk_common_color_10218);
        }
        throw new IllegalArgumentException(TYPE_ERROR);
    }

    public static int getBarTextUnselColor(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(a.c.sdk_common_color_10219);
        }
        throw new IllegalArgumentException(TYPE_ERROR);
    }

    public static int getBgColor(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(a.c.sdk_common_color_10150) : app.getResources().getColor(a.c.sdk_common_color_10163);
    }

    public static void setNineTextColorMode(TextView textView, boolean z) {
        Application app = BdBaseApplication.getInst().getApp();
        if (z) {
            textView.setTextColor(app.getResources().getColor(a.c.sdk_cp_bg_line_d));
        } else {
            setViewTextColor(textView, a.c.sdk_cp_bg_line_d, 1);
        }
    }

    public static void setLvSelector(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(a.e.sdk_list_selector));
        }
    }

    public static void setCommonListView(ListView listView, int i) {
        if (listView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            setBackgroundColor(listView, a.c.sdk_common_color_10163);
            listView.setCacheColorHint(app.getResources().getColor(17170445));
            listView.setDivider(getDrawable(a.e.sdk_list_divider));
            listView.setSelector(getDrawable(a.e.sdk_list_selector));
        }
    }

    public static void setCommonListViewNoBackground(ListView listView, int i) {
        if (listView != null) {
            listView.setCacheColorHint(BdBaseApplication.getInst().getApp().getResources().getColor(17170445));
            listView.setDivider(getDrawable(a.e.sdk_list_divider));
            listView.setSelector(getDrawable(a.e.sdk_list_selector));
        }
    }

    public static void setListViewNoDivider(ListView listView, int i) {
        if (listView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            setBackgroundColor(listView, a.c.sdk_common_color_10163);
            listView.setCacheColorHint(app.getResources().getColor(17170445));
            listView.setSelector(getDrawable(a.e.sdk_list_selector));
        }
    }

    public static void setNormalBackgroundResource(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundResource(i);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2) {
        setNavbarIconSrc(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && imageView != null) {
            if (i3 == 1) {
                setImageResource(imageView, i2, i3);
            } else {
                setImageResource(imageView, i, i3);
            }
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3, int i4) {
        if (i != 0 && i2 != 0 && imageView != null) {
            if (i4 == 1) {
                setImageResource(imageView, i3, i4);
            } else {
                setImageResource(imageView, i, i4);
            }
        }
    }

    public static void setNavbarTitleColor(View view, int i, int i2) {
        setNavbarTitleColor(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarTitleColor(View view, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && view != null) {
            setViewTextColor(view, i);
        }
    }

    private static int getSkinResourceId(Resources resources, int i) {
        String str;
        if (mSkinRes == null) {
            mSkinRes = resources;
        }
        if (mSkinRes == null) {
            return 0;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (StringUtils.isNull(str)) {
            return 0;
        }
        String substring = str.substring(str.indexOf("/"));
        if (StringUtils.isNull(substring) || !substring.startsWith("/s_")) {
            return 0;
        }
        return mSkinRes.getIdentifier(BdBaseApplication.getInst().getPackageName() + str.substring(str.indexOf(":")), null, null);
    }

    public static void setViewTextColor(View view, int i) {
        setViewTextColor(view, i, 1);
    }

    public static Drawable getSkinDrawable(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int skinResourceId = getSkinResourceId(resources, i);
        if (skinResourceId == 0) {
            resources2 = resources;
            skinResourceId = i;
        } else if (mSkinRes != null) {
            resources2 = mSkinRes;
        } else {
            resources2 = resources;
            skinResourceId = i;
        }
        try {
            return resources2.getDrawable(skinResourceId);
        } catch (Throwable th) {
            return resources.getDrawable(i);
        }
    }

    public static int getSkinColor(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int skinResourceId = getSkinResourceId(resources, i);
        if (skinResourceId == 0) {
            resources2 = resources;
            skinResourceId = i;
        } else if (mSkinRes != null) {
            resources2 = mSkinRes;
        } else {
            resources2 = resources;
            skinResourceId = i;
        }
        try {
            return resources2.getColor(skinResourceId);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return resources.getColor(i);
        }
    }

    public static ColorStateList getSkinColorList(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int skinResourceId = getSkinResourceId(resources, i);
        if (skinResourceId == 0) {
            resources2 = resources;
            skinResourceId = i;
        } else if (mSkinRes != null) {
            resources2 = mSkinRes;
        } else {
            resources2 = resources;
            skinResourceId = i;
        }
        try {
            return resources2.getColorStateList(skinResourceId);
        } catch (Throwable th) {
            return resources.getColorStateList(i);
        }
    }

    public static int getColor(int i, Resources resources, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        try {
            return resources.getColor(i2);
        } catch (Throwable th) {
            return resources.getColor(i2);
        }
    }

    public static int getColor(int i, int i2) {
        return getColor(i, null, i2);
    }

    public static int getColor(Resources resources, int i) {
        return getColor(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static int getColor(int i) {
        return getColor(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static ColorStateList getColorList(int i, Resources resources, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        try {
            return resources.getColorStateList(i2);
        } catch (Throwable th) {
            return resources.getColorStateList(i2);
        }
    }

    public static ColorStateList getColorList(Resources resources, int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static ColorStateList getColorList(int i, int i2) {
        return getColorList(i, null, i2);
    }

    public static ColorStateList getColorList(int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable getDrawable(int i, Resources resources, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        try {
            return resources.getDrawable(i2);
        } catch (Throwable th) {
            try {
                return resources.getDrawable(i2);
            } catch (Throwable th2) {
                return null;
            }
        }
    }

    public static Drawable getDrawable(Resources resources, int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable getDrawable(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return getDrawable(i, null, i2);
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options) {
        return getBitmap(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int getVectorToDefaultResId(Resources resources, int i) {
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        try {
            String resourceName = resources.getResourceName(i);
            if (StringUtils.isNull(resourceName)) {
                return 0;
            }
            String replace = resourceName.replace("_svg", "");
            if (replace.indexOf(":") <= 0 || mPluginRes == null) {
                return 0;
            }
            if (sPacknameLength == 0) {
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                replace = sPackagename + replace.substring(replace.indexOf(":"));
            }
            return mPluginRes.getIdentifier(replace + nightSufix, null, null);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options, int i2) {
        if (i == 0) {
            return null;
        }
        return BitmapHelper.getCashBitmap(i, options);
    }

    public static Bitmap getBitmapAllowFail(Resources resources, int i) {
        return getBitmap(i);
    }

    public static Bitmap getBitmap(int i) {
        return getBitmap(null, i, new BitmapFactory.Options());
    }

    public static Bitmap getBitmapLowQuality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return getBitmap(null, i, options);
    }

    public static Bitmap getBitmapLowQuality(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return getBitmap(null, i, options, i2);
    }

    public static Bitmap getBitmap565Quality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return getBitmap(null, i, options);
    }

    public static Bitmap getBitmapQuiteLowQuality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        return getBitmap(null, i, options);
    }

    public static void setViewTextColor(View view, int i, int i2, int i3) {
        ColorStateList colorList;
        if (view != null && i != 0 && view.getResources() != null) {
            if (i3 == 0) {
                colorList = view.getResources().getColorStateList(i);
            } else {
                colorList = getColorList(i3, view.getResources(), i);
            }
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(colorList);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(colorList);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(colorList);
            } else if (i2 == 4 && (view instanceof CheckBox)) {
                ((CheckBox) view).setTextColor(colorList);
            }
        }
    }

    public static void setViewTextColor(View view, int i, int i2) {
        setViewTextColor(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static boolean setViewTextColor(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList colorList;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (colorList = getColorList(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(colorList);
        return true;
    }

    public static void setImageResource(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(getDrawable(imageView.getResources(), i));
        }
    }

    public static void setImageResourceFromContainer(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(getDrawable((Resources) null, i));
        }
    }

    public static void setImageResource(ImageView imageView, int i, int i2) {
        if (imageView != null && i != 0) {
            Drawable drawable = null;
            if (i2 == 0) {
                try {
                    drawable = imageView.getResources().getDrawable(i);
                } catch (Throwable th) {
                }
            } else {
                drawable = getDrawable(i2, imageView.getResources(), i);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void setBackgroundResource(View view, int i) {
        setBackgroundResource(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundResource(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(getDrawable(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i) {
        setBackgroundDrawable(popupWindow, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i, int i2) {
        if (popupWindow != null && i != 0) {
            popupWindow.setBackgroundDrawable(getDrawable(i2, i));
        }
    }

    public static void setBackgroundColor(View view, int i) {
        setBackgroundColor(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundColor(View view, int i, int i2) {
        int color;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                color = view.getResources().getColor(i);
            } else {
                color = getColor(i2, view.getResources(), i);
            }
            view.setBackgroundColor(color);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }
}
