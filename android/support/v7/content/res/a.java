package android.support.v7.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
final class a {
    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return c(resources, xmlPullParser, asAttributeSet, theme);
    }

    private static ColorStateList c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return d(resources, xmlPullParser, attributeSet, theme);
    }

    private static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[][] iArr2 = iArr;
        int i2 = 0;
        int[] iArr3 = new int[iArr.length];
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray a = a(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                int color = a.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (a.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                    f = a.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (a.hasValue(R.styleable.ColorStateListItem_alpha)) {
                    f = a.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                a.recycle();
                int i3 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr4 = new int[attributeCount];
                int i4 = 0;
                while (i4 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.alpha) {
                        i = i3;
                    } else {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr4[i3] = attributeNameResource;
                        i = i5;
                    }
                    i4++;
                    i3 = i;
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr4, i3);
                int f2 = f(color, f);
                if (i2 == 0 || trimStateSet.length == 0) {
                }
                int[] b = b.b(iArr3, i2, f2);
                i2++;
                iArr2 = (int[][]) b.a(iArr2, i2, trimStateSet);
                iArr3 = b;
            }
        }
        int[] iArr5 = new int[i2];
        int[][] iArr6 = new int[i2];
        System.arraycopy(iArr3, 0, iArr5, 0, i2);
        System.arraycopy(iArr2, 0, iArr6, 0, i2);
        return new ColorStateList(iArr6, iArr5);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int f(int i, float f) {
        return ColorUtils.setAlphaComponent(i, Math.round(Color.alpha(i) * f));
    }
}
