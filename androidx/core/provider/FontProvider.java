package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class FontProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<byte[]> sByteArrayComparator;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(882064051, "Landroidx/core/provider/FontProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(882064051, "Landroidx/core/provider/FontProvider;");
                return;
            }
        }
        sByteArrayComparator = new Comparator<byte[]>() { // from class: androidx.core.provider.FontProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                int i;
                int i2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
                    if (bArr.length != bArr2.length) {
                        i = bArr.length;
                        i2 = bArr2.length;
                    } else {
                        for (int i3 = 0; i3 < bArr.length; i3++) {
                            if (bArr[i3] != bArr2[i3]) {
                                i = bArr[i3];
                                i2 = bArr2[i3];
                            }
                        }
                        return 0;
                    }
                    return i - i2;
                }
                return invokeLL.intValue;
            }
        };
    }

    public FontProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, signatureArr)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, list2)) == null) {
            if (list.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                if (!Arrays.equals(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fontRequest, resources)) == null) {
            if (fontRequest.getCertificates() != null) {
                return fontRequest.getCertificates();
            }
            return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context context, @NonNull FontRequest fontRequest, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, fontRequest, cancellationSignal)) == null) {
            ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
            if (provider == null) {
                return FontsContractCompat.FontFamilyResult.create(1, null);
            }
            return FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
        }
        return (FontsContractCompat.FontFamilyResult) invokeLLL.objValue;
    }

    @Nullable
    @VisibleForTesting
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, packageManager, fontRequest, resources)) == null) {
            String providerAuthority = fontRequest.getProviderAuthority();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                    List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                    Collections.sort(convertToByteArrayList, sByteArrayComparator);
                    List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
                    for (int i = 0; i < certificates.size(); i++) {
                        ArrayList arrayList = new ArrayList(certificates.get(i));
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

    @NonNull
    @VisibleForTesting
    public static FontsContractCompat.FontInfo[] query(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        int i3;
        Uri withAppendedId;
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, context, fontRequest, str, cancellationSignal)) == null) {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, "result_code"};
                if (Build.VERSION.SDK_INT > 16) {
                    cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
                } else {
                    cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{fontRequest.getQuery()}, null);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("result_code");
                    ArrayList arrayList2 = new ArrayList();
                    int columnIndex2 = cursor.getColumnIndex("_id");
                    int columnIndex3 = cursor.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                    int columnIndex4 = cursor.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                    int columnIndex5 = cursor.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                    int columnIndex6 = cursor.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                    while (cursor.moveToNext()) {
                        if (columnIndex != -1) {
                            i = cursor.getInt(columnIndex);
                        } else {
                            i = 0;
                        }
                        if (columnIndex4 != -1) {
                            i2 = cursor.getInt(columnIndex4);
                        } else {
                            i2 = 0;
                        }
                        if (columnIndex3 == -1) {
                            i3 = i;
                            withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                        } else {
                            i3 = i;
                            withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                        }
                        if (columnIndex5 != -1) {
                            i4 = cursor.getInt(columnIndex5);
                        } else {
                            i4 = 400;
                        }
                        if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        arrayList2.add(FontsContractCompat.FontInfo.create(withAppendedId, i2, i4, z, i3));
                    }
                    arrayList = arrayList2;
                }
                return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return (FontsContractCompat.FontInfo[]) invokeLLLL.objValue;
    }
}
