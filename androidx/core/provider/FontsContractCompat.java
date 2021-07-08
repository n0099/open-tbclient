package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class FontsContractCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    public static final SelfDestructiveThread sBackgroundThread;
    public static final Comparator<byte[]> sByteArrayComparator;
    public static final Object sLock;
    @GuardedBy("sLock")
    public static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies;
    public static final LruCache<String, Typeface> sTypefaceCache;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class Columns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
        public transient /* synthetic */ FieldHolder $fh;

        public Columns() {
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
    }

    /* loaded from: classes.dex */
    public static class FontFamilyResult {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final FontInfo[] mFonts;
        public final int mStatusCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i2, @Nullable FontInfo[] fontInfoArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), fontInfoArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStatusCode = i2;
            this.mFonts = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFonts : (FontInfo[]) invokeV.objValue;
        }

        public int getStatusCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStatusCode : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class FontInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mItalic;
        public final int mResultCode;
        public final int mTtcIndex;
        public final Uri mUri;
        public final int mWeight;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uri, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = i2;
            this.mWeight = i3;
            this.mItalic = z;
            this.mResultCode = i4;
        }

        public int getResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultCode : invokeV.intValue;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTtcIndex : invokeV.intValue;
        }

        @NonNull
        public Uri getUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mUri : (Uri) invokeV.objValue;
        }

        @IntRange(from = 1, to = 1000)
        public int getWeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWeight : invokeV.intValue;
        }

        public boolean isItalic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mItalic : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* loaded from: classes.dex */
        public @interface FontRequestFailReason {
        }

        public FontRequestCallback() {
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

        public void onTypefaceRequestFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        public void onTypefaceRetrieved(Typeface typeface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class TypefaceResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(@Nullable Typeface typeface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeface, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTypeface = typeface;
            this.mResult = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329132555, "Landroidx/core/provider/FontsContractCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329132555, "Landroidx/core/provider/FontsContractCompat;");
                return;
            }
        }
        sTypefaceCache = new LruCache<>(16);
        sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
        sLock = new Object();
        sPendingReplies = new SimpleArrayMap<>();
        sByteArrayComparator = new Comparator<byte[]>() { // from class: androidx.core.provider.FontsContractCompat.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: char */
            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: char */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                InterceptResult invokeLL;
                int i2;
                int i3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
                    if (bArr.length != bArr2.length) {
                        i2 = bArr.length;
                        i3 = bArr2.length;
                    } else {
                        for (int i4 = 0; i4 < bArr.length; i4++) {
                            if (bArr[i4] != bArr2[i4]) {
                                i2 = bArr[i4];
                                i3 = bArr2[i4];
                            }
                        }
                        return 0;
                    }
                    return i2 - i3;
                }
                return invokeLL.intValue;
            }
        };
    }

    public FontsContractCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, cancellationSignal, fontInfoArr)) == null) ? TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0) : (Typeface) invokeLLL.objValue;
    }

    public static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, signatureArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, list2)) == null) {
            if (list.size() != list2.size()) {
                return false;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, cancellationSignal, fontRequest)) == null) {
            ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
            if (provider == null) {
                return new FontFamilyResult(1, null);
            }
            return new FontFamilyResult(0, getFontFromProvider(context, fontRequest, provider.authority, cancellationSignal));
        }
        return (FontFamilyResult) invokeLLL.objValue;
    }

    public static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, fontRequest, resources)) == null) {
            if (fontRequest.getCertificates() != null) {
                return fontRequest.getCertificates();
            }
            return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    @VisibleForTesting
    public static FontInfo[] getFontFromProvider(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLL;
        Uri withAppendedId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, context, fontRequest, str, cancellationSignal)) == null) {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            Cursor cursor = null;
            try {
                if (Build.VERSION.SDK_INT > 16) {
                    cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, "result_code"}, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
                } else {
                    cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, "result_code"}, "query = ?", new String[]{fontRequest.getQuery()}, null);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    ArrayList arrayList2 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex("file_id");
                    int columnIndex4 = cursor.getColumnIndex(Columns.TTC_INDEX);
                    int columnIndex5 = cursor.getColumnIndex(Columns.WEIGHT);
                    int columnIndex6 = cursor.getColumnIndex(Columns.ITALIC);
                    while (cursor.moveToNext()) {
                        int i2 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                        int i3 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                        if (columnIndex3 == -1) {
                            withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                        } else {
                            withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                        }
                        arrayList2.add(new FontInfo(withAppendedId, i3, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i2));
                    }
                    arrayList = arrayList2;
                }
                return (FontInfo[]) arrayList.toArray(new FontInfo[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return (FontInfo[]) invokeLLLL.objValue;
    }

    @NonNull
    public static TypefaceResult getFontInternal(Context context, FontRequest fontRequest, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, context, fontRequest, i2)) == null) {
            try {
                FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
                if (fetchFonts.getStatusCode() == 0) {
                    Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fetchFonts.getFonts(), i2);
                    return new TypefaceResult(createFromFontInfo, createFromFontInfo != null ? 0 : -3);
                }
                return new TypefaceResult(null, fetchFonts.getStatusCode() == 1 ? -2 : -3);
            } catch (PackageManager.NameNotFoundException unused) {
                return new TypefaceResult(null, -1);
            }
        }
        return (TypefaceResult) invokeLLI.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFontSync(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, fontRequest, fontCallback, handler, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str = fontRequest.getIdentifier() + "-" + i3;
            Typeface typeface = sTypefaceCache.get(str);
            if (typeface != null) {
                if (fontCallback != null) {
                    fontCallback.onFontRetrieved(typeface);
                }
                return typeface;
            } else if (z && i2 == -1) {
                TypefaceResult fontInternal = getFontInternal(context, fontRequest, i3);
                if (fontCallback != null) {
                    int i4 = fontInternal.mResult;
                    if (i4 == 0) {
                        fontCallback.callbackSuccessAsync(fontInternal.mTypeface, handler);
                    } else {
                        fontCallback.callbackFailAsync(i4, handler);
                    }
                }
                return fontInternal.mTypeface;
            } else {
                Callable<TypefaceResult> callable = new Callable<TypefaceResult>(context, fontRequest, i3, str) { // from class: androidx.core.provider.FontsContractCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$id;
                    public final /* synthetic */ FontRequest val$request;
                    public final /* synthetic */ int val$style;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, fontRequest, Integer.valueOf(i3), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$request = fontRequest;
                        this.val$style = i3;
                        this.val$id = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public TypefaceResult call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            TypefaceResult fontInternal2 = FontsContractCompat.getFontInternal(this.val$context, this.val$request, this.val$style);
                            Typeface typeface2 = fontInternal2.mTypeface;
                            if (typeface2 != null) {
                                FontsContractCompat.sTypefaceCache.put(this.val$id, typeface2);
                            }
                            return fontInternal2;
                        }
                        return (TypefaceResult) invokeV.objValue;
                    }
                };
                if (z) {
                    try {
                        return ((TypefaceResult) sBackgroundThread.postAndWait(callable, i2)).mTypeface;
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
                SelfDestructiveThread.ReplyCallback<TypefaceResult> replyCallback = fontCallback == null ? null : new SelfDestructiveThread.ReplyCallback<TypefaceResult>(fontCallback, handler) { // from class: androidx.core.provider.FontsContractCompat.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ResourcesCompat.FontCallback val$fontCallback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {fontCallback, handler};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$fontCallback = fontCallback;
                        this.val$handler = handler;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                    public void onReply(TypefaceResult typefaceResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, typefaceResult) == null) {
                            if (typefaceResult == null) {
                                this.val$fontCallback.callbackFailAsync(1, this.val$handler);
                                return;
                            }
                            int i5 = typefaceResult.mResult;
                            if (i5 == 0) {
                                this.val$fontCallback.callbackSuccessAsync(typefaceResult.mTypeface, this.val$handler);
                            } else {
                                this.val$fontCallback.callbackFailAsync(i5, this.val$handler);
                            }
                        }
                    }
                };
                synchronized (sLock) {
                    ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = sPendingReplies.get(str);
                    if (arrayList != null) {
                        if (replyCallback != null) {
                            arrayList.add(replyCallback);
                        }
                        return null;
                    }
                    if (replyCallback != null) {
                        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList2 = new ArrayList<>();
                        arrayList2.add(replyCallback);
                        sPendingReplies.put(str, arrayList2);
                    }
                    sBackgroundThread.postAndReply(callable, new SelfDestructiveThread.ReplyCallback<TypefaceResult>(str) { // from class: androidx.core.provider.FontsContractCompat.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String val$id;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$id = str;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                        public void onReply(TypefaceResult typefaceResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, typefaceResult) == null) {
                                synchronized (FontsContractCompat.sLock) {
                                    ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList3 = FontsContractCompat.sPendingReplies.get(this.val$id);
                                    if (arrayList3 == null) {
                                        return;
                                    }
                                    FontsContractCompat.sPendingReplies.remove(this.val$id);
                                    for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                                        arrayList3.get(i5).onReply(typefaceResult);
                                    }
                                }
                            }
                        }
                    });
                    return null;
                }
            }
        }
        return (Typeface) invokeCommon.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, packageManager, fontRequest, resources)) == null) {
            String providerAuthority = fontRequest.getProviderAuthority();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                    List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                    Collections.sort(convertToByteArrayList, sByteArrayComparator);
                    List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
                    for (int i2 = 0; i2 < certificates.size(); i2++) {
                        ArrayList arrayList = new ArrayList(certificates.get(i2));
                        Collections.sort(arrayList, sByteArrayComparator);
                        if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                            return resolveContentProvider;
                        }
                    }
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        return (ProviderInfo) invokeLLL.objValue;
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, fontInfoArr, cancellationSignal)) == null) {
            HashMap hashMap = new HashMap();
            for (FontInfo fontInfo : fontInfoArr) {
                if (fontInfo.getResultCode() == 0) {
                    Uri uri = fontInfo.getUri();
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                    }
                }
            }
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLLL.objValue;
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, fontRequest, fontRequestCallback, handler) == null) {
            requestFontInternal(context.getApplicationContext(), fontRequest, fontRequestCallback, handler);
        }
    }

    public static void requestFontInternal(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, context, fontRequest, fontRequestCallback, handler) == null) {
            handler.post(new Runnable(context, fontRequest, new Handler(), fontRequestCallback) { // from class: androidx.core.provider.FontsContractCompat.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$appContext;
                public final /* synthetic */ FontRequestCallback val$callback;
                public final /* synthetic */ Handler val$callerThreadHandler;
                public final /* synthetic */ FontRequest val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, fontRequest, r8, fontRequestCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$appContext = context;
                    this.val$request = fontRequest;
                    this.val$callerThreadHandler = r8;
                    this.val$callback = fontRequestCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(this.val$appContext, null, this.val$request);
                            if (fetchFonts.getStatusCode() != 0) {
                                int statusCode = fetchFonts.getStatusCode();
                                if (statusCode == 1) {
                                    this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.2
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$0;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$0.val$callback.onTypefaceRequestFailed(-2);
                                            }
                                        }
                                    });
                                    return;
                                } else if (statusCode != 2) {
                                    this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.4
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$0;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$0.val$callback.onTypefaceRequestFailed(-3);
                                            }
                                        }
                                    });
                                    return;
                                } else {
                                    this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$0;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$0.val$callback.onTypefaceRequestFailed(-3);
                                            }
                                        }
                                    });
                                    return;
                                }
                            }
                            FontInfo[] fonts = fetchFonts.getFonts();
                            if (fonts != null && fonts.length != 0) {
                                for (FontInfo fontInfo : fonts) {
                                    if (fontInfo.getResultCode() != 0) {
                                        int resultCode = fontInfo.getResultCode();
                                        if (resultCode < 0) {
                                            this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.6
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass4 this$0;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        this.this$0.val$callback.onTypefaceRequestFailed(-3);
                                                    }
                                                }
                                            });
                                            return;
                                        } else {
                                            this.val$callerThreadHandler.post(new Runnable(this, resultCode) { // from class: androidx.core.provider.FontsContractCompat.4.7
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass4 this$0;
                                                public final /* synthetic */ int val$resultCode;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this, Integer.valueOf(resultCode)};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                    this.val$resultCode = resultCode;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        this.this$0.val$callback.onTypefaceRequestFailed(this.val$resultCode);
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                    }
                                }
                                Typeface buildTypeface = FontsContractCompat.buildTypeface(this.val$appContext, null, fonts);
                                if (buildTypeface == null) {
                                    this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.8
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$0;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$0.val$callback.onTypefaceRequestFailed(-3);
                                            }
                                        }
                                    });
                                    return;
                                } else {
                                    this.val$callerThreadHandler.post(new Runnable(this, buildTypeface) { // from class: androidx.core.provider.FontsContractCompat.4.9
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass4 this$0;
                                        public final /* synthetic */ Typeface val$typeface;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, buildTypeface};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$0 = this;
                                            this.val$typeface = buildTypeface;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$0.val$callback.onTypefaceRetrieved(this.val$typeface);
                                            }
                                        }
                                    });
                                    return;
                                }
                            }
                            this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$0.val$callback.onTypefaceRequestFailed(1);
                                    }
                                }
                            });
                        } catch (PackageManager.NameNotFoundException unused) {
                            this.val$callerThreadHandler.post(new Runnable(this) { // from class: androidx.core.provider.FontsContractCompat.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$0.val$callback.onTypefaceRequestFailed(-1);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            sTypefaceCache.evictAll();
        }
    }
}
