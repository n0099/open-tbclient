package com.baidu.searchbox.ui.drawable;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.baidu.searchbox.ui.drawable.ColorStateDrawable;
import com.baidu.searchbox.ui.drawable.LazyStateListDrawable;
import com.baidu.spswitch.emotion.Emoticons;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes4.dex */
public class BdDrawable {
    public static final boolean DEBUG = false;
    public static final String TAG = "BdDrawable";

    /* loaded from: classes4.dex */
    public static final class InflatedStateValue {
        public int drawable;
        public int[] state;

        public InflatedStateValue(int[] iArr, int i) {
            this.state = iArr;
            this.drawable = i;
        }
    }

    public static void addColorStateForView(@NonNull View view2, @ColorRes int i) {
        view2.setBackground(new ColorStateDrawable.ColorStateBuilder().setBaseDrawable(view2.getBackground()).setColorStateList(new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i, 17170445}), PorterDuff.Mode.SRC_OVER).build());
    }

    public static Drawable createFromXml(@NonNull Resources resources, @DrawableRes int i) {
        int next;
        try {
            XmlResourceParser openXmlResourceParser = resources.getAssets().openXmlResourceParser(String.format("res/%s/%s.xml", resources.getResourceTypeName(i), resources.getResourceEntryName(i)));
            while (true) {
                next = openXmlResourceParser.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next != 2 || !"selector".equals(openXmlResourceParser.getName())) {
                return null;
            }
            List<InflatedStateValue> inflateChildElements = inflateChildElements(openXmlResourceParser, Xml.asAttributeSet(openXmlResourceParser));
            LazyStateListDrawable.DrawableStateBuilder drawableStateBuilder = new LazyStateListDrawable.DrawableStateBuilder(resources);
            for (InflatedStateValue inflatedStateValue : inflateChildElements) {
                if (inflatedStateValue.state.length == 0) {
                    drawableStateBuilder.addStateDrawable(inflatedStateValue.state, inflatedStateValue.drawable, true);
                } else {
                    drawableStateBuilder.addStateDrawable(inflatedStateValue.state, inflatedStateValue.drawable, false);
                }
            }
            return drawableStateBuilder.build();
        } catch (IOException | XmlPullParserException unused) {
            return resources.getDrawable(i);
        }
    }

    public static int[] extractStateSet(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int identifier = Resources.getSystem().getIdentifier(ResourceManager.DRAWABLE, Emoticons.KEY_ATTR, "android");
        int identifier2 = Resources.getSystem().getIdentifier("id", Emoticons.KEY_ATTR, "android");
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource == 0) {
                break;
            }
            if (attributeNameResource != identifier && attributeNameResource != identifier2) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @SuppressLint({"BDOfflineUrl"})
    public static List<InflatedStateValue> inflateChildElements(XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth;
        ArrayList arrayList = new ArrayList();
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                int[] extractStateSet = extractStateSet(attributeSet);
                int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", ResourceManager.DRAWABLE, -1);
                if (attributeResourceValue != -1) {
                    arrayList.add(new InflatedStateValue(extractStateSet, attributeResourceValue));
                }
            }
        }
        return arrayList;
    }
}
