package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FontResourcesParserCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    public static final int ITALIC = 1;
    public static final int NORMAL_WEIGHT = 400;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FetchStrategy {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fontFileResourceEntryArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEntries = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEntries : (FontFileResourceEntry[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String mFileName;
        public boolean mItalic;
        public int mResourceId;
        public int mTtcIndex;
        public String mVariationSettings;
        public int mWeight;

        public FontFileResourceEntry(@NonNull String str, int i2, boolean z, @Nullable String str2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), str2, Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mFileName = str;
            this.mWeight = i2;
            this.mItalic = z;
            this.mVariationSettings = str2;
            this.mTtcIndex = i3;
            this.mResourceId = i4;
        }

        @NonNull
        public String getFileName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFileName : (String) invokeV.objValue;
        }

        public int getResourceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mResourceId : invokeV.intValue;
        }

        public int getTtcIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTtcIndex : invokeV.intValue;
        }

        @Nullable
        public String getVariationSettings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVariationSettings : (String) invokeV.objValue;
        }

        public int getWeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWeight : invokeV.intValue;
        }

        public boolean isItalic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mItalic : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final FontRequest mRequest;
        public final int mStrategy;
        public final int mTimeoutMs;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fontRequest, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRequest = fontRequest;
            this.mStrategy = i2;
            this.mTimeoutMs = i3;
        }

        public int getFetchStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mStrategy : invokeV.intValue;
        }

        @NonNull
        public FontRequest getRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRequest : (FontRequest) invokeV.objValue;
        }

        public int getTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTimeoutMs : invokeV.intValue;
        }
    }

    public FontResourcesParserCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getType(TypedArray typedArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, typedArray, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return typedArray.getType(i2);
            }
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            return typedValue.type;
        }
        return invokeLI.intValue;
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xmlPullParser, resources)) == null) {
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return readFamilies(xmlPullParser, resources);
            }
            throw new XmlPullParserException("No start tag found");
        }
        return (FamilyResourceEntry) invokeLL.objValue;
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, resources, i2)) == null) {
            if (i2 == 0) {
                return Collections.emptyList();
            }
            TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
            try {
                if (obtainTypedArray.length() == 0) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                if (getType(obtainTypedArray, 0) == 1) {
                    for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                        int resourceId = obtainTypedArray.getResourceId(i3, 0);
                        if (resourceId != 0) {
                            arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(toByteArrayList(resources.getStringArray(i2)));
                }
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }
        return (List) invokeLI.objValue;
    }

    @Nullable
    public static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xmlPullParser, resources)) == null) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                return readFamily(xmlPullParser, resources);
            }
            skip(xmlPullParser);
            return null;
        }
        return (FamilyResourceEntry) invokeLL.objValue;
    }

    @Nullable
    public static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, xmlPullParser, resources)) == null) {
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
            String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
            String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
            String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
            int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
            int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
            int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
            obtainAttributes.recycle();
            if (string != null && string2 != null && string3 != null) {
                while (xmlPullParser.next() != 3) {
                    skip(xmlPullParser);
                }
                return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
            }
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(readFont(xmlPullParser, resources));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
        }
        return (FamilyResourceEntry) invokeLL.objValue;
    }

    public static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, xmlPullParser, resources)) == null) {
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
            if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
                i2 = R.styleable.FontFamilyFont_fontWeight;
            } else {
                i2 = R.styleable.FontFamilyFont_android_fontWeight;
            }
            int i7 = obtainAttributes.getInt(i2, 400);
            if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
                i3 = R.styleable.FontFamilyFont_fontStyle;
            } else {
                i3 = R.styleable.FontFamilyFont_android_fontStyle;
            }
            boolean z = 1 == obtainAttributes.getInt(i3, 0);
            if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
                i4 = R.styleable.FontFamilyFont_ttcIndex;
            } else {
                i4 = R.styleable.FontFamilyFont_android_ttcIndex;
            }
            if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
                i5 = R.styleable.FontFamilyFont_fontVariationSettings;
            } else {
                i5 = R.styleable.FontFamilyFont_android_fontVariationSettings;
            }
            String string = obtainAttributes.getString(i5);
            int i8 = obtainAttributes.getInt(i4, 0);
            if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_font)) {
                i6 = R.styleable.FontFamilyFont_font;
            } else {
                i6 = R.styleable.FontFamilyFont_android_font;
            }
            int resourceId = obtainAttributes.getResourceId(i6, 0);
            String string2 = obtainAttributes.getString(i6);
            obtainAttributes.recycle();
            while (xmlPullParser.next() != 3) {
                skip(xmlPullParser);
            }
            return new FontFileResourceEntry(string2, i7, z, string, i8, resourceId);
        }
        return (FontFileResourceEntry) invokeLL.objValue;
    }

    public static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, xmlPullParser) == null) {
            int i2 = 1;
            while (i2 > 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i2++;
                } else if (next == 3) {
                    i2--;
                }
            }
        }
    }

    public static List<byte[]> toByteArrayList(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
