package com.android.support.appcompat.storage;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tieba.a0;
import com.baidu.tieba.y;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.InputStream;
/* loaded from: classes.dex */
public class MediaFileProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class UriSource {
        public static final /* synthetic */ UriSource[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UriSource AUDIO;
        public static final UriSource DOWNLOAD;
        public static final UriSource IMAGE;
        public static final UriSource VIDEO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(611017836, "Lcom/android/support/appcompat/storage/MediaFileProcessor$UriSource;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(611017836, "Lcom/android/support/appcompat/storage/MediaFileProcessor$UriSource;");
                    return;
                }
            }
            IMAGE = new UriSource("IMAGE", 0);
            AUDIO = new UriSource(HlsPlaylistParser.TYPE_AUDIO, 1);
            VIDEO = new UriSource(HlsPlaylistParser.TYPE_VIDEO, 2);
            UriSource uriSource = new UriSource("DOWNLOAD", 3);
            DOWNLOAD = uriSource;
            $VALUES = new UriSource[]{IMAGE, AUDIO, VIDEO, uriSource};
        }

        public UriSource(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static UriSource valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (UriSource) Enum.valueOf(UriSource.class, str);
            }
            return (UriSource) invokeL.objValue;
        }

        public static UriSource[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (UriSource[]) $VALUES.clone();
            }
            return (UriSource[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-627822638, "Lcom/android/support/appcompat/storage/MediaFileProcessor$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-627822638, "Lcom/android/support/appcompat/storage/MediaFileProcessor$a;");
                    return;
                }
            }
            int[] iArr = new int[UriSource.values().length];
            a = iArr;
            try {
                iArr[UriSource.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UriSource.AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UriSource.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UriSource.DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Uri a(UriSource uriSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uriSource)) == null) {
            int i = a.a[uriSource.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        if (Build.VERSION.SDK_INT < 29) {
                            return MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH);
                        }
                        return MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                    }
                    return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                }
                return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return (Uri) invokeL.objValue;
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr, y yVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, uri, str, strArr, yVar)) == null) {
            return a0.a(context).delete(uri, str, strArr, yVar);
        }
        return invokeLLLLL.intValue;
    }

    public static Uri insert(Context context, InputStream inputStream, UriSource uriSource, ContentValues contentValues, String str) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, context, inputStream, uriSource, contentValues, str)) == null) {
            return a0.a(context).insert(inputStream, uriSource, contentValues, str);
        }
        return (Uri) invokeLLLLL.objValue;
    }

    @TargetApi(26)
    public static Cursor query(Context context, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, context, uri, strArr, bundle, cancellationSignal)) == null) {
            return context.getContentResolver().query(uri, strArr, bundle, cancellationSignal);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr, String str2, y yVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, uri, str, strArr, str2, yVar})) == null) {
            return a0.a(context).delete(uri, str, strArr, str2, yVar);
        }
        return invokeCommon.intValue;
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, uri, strArr, str, strArr2, str2})) == null) {
            return context.getContentResolver().query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr, y yVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, uri, contentValues, str, strArr, yVar})) == null) {
            return a0.a(context).update(uri, contentValues, str, strArr, yVar);
        }
        return invokeCommon.intValue;
    }

    public static int delete(Context context, UriSource uriSource, String str, String[] strArr, y yVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, uriSource, str, strArr, yVar)) == null) {
            return delete(context, a(uriSource), str, strArr, yVar);
        }
        return invokeLLLLL.intValue;
    }

    public static Cursor query(Context context, UriSource uriSource, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, context, uriSource, strArr, bundle, cancellationSignal)) == null) {
            return query(context, a(uriSource), strArr, bundle, cancellationSignal);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public static int delete(Context context, UriSource uriSource, String str, String[] strArr, String str2, y yVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, uriSource, str, strArr, str2, yVar})) == null) {
            return delete(context, a(uriSource), str, strArr, str2, yVar);
        }
        return invokeCommon.intValue;
    }

    public static Cursor query(Context context, UriSource uriSource, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, uriSource, strArr, str, strArr2, str2})) == null) {
            return query(context, a(uriSource), strArr, str, strArr2, str2);
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static int update(Context context, UriSource uriSource, ContentValues contentValues, String str, String[] strArr, y yVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, uriSource, contentValues, str, strArr, yVar})) == null) {
            return update(context, a(uriSource), contentValues, str, strArr, yVar);
        }
        return invokeCommon.intValue;
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, uri, contentValues)) == null) {
            return context.getContentResolver().insert(uri, contentValues);
        }
        return (Uri) invokeLLL.objValue;
    }

    public static Uri insert(Context context, UriSource uriSource, ContentValues contentValues) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, uriSource, contentValues)) == null) {
            return insert(context, a(uriSource), contentValues);
        }
        return (Uri) invokeLLL.objValue;
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            return context.getContentResolver().query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static Cursor query(Context context, UriSource uriSource, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, uriSource, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            return query(context, a(uriSource), strArr, str, strArr2, str2, cancellationSignal);
        }
        return (Cursor) invokeCommon.objValue;
    }
}
