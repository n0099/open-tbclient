package c.b.b.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bd.c.h;
import ms.bd.c.j;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes4.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.b.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1442a {
        @POST
        @Streaming
        Call<TypedInput> a(@Url String str, @HeaderList List<Header> list, @Body TypedByteArray typedByteArray);

        @GET
        @Streaming
        Call<TypedInput> b(@Url String str, @HeaderList List<Header> list);
    }

    public a() {
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

    @Override // c.b.b.a.a.b
    public Object[] e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? i(str, null, null, str2, false) : (Object[]) invokeLL.objValue;
    }

    @Override // c.b.b.a.a.b
    public Object[] f(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, str2)) == null) ? i(str, bArr, str2, null, true) : (Object[]) invokeLLL.objValue;
    }

    @Override // c.b.b.a.a.b
    public Object[] g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? i(str, null, str2, null, false) : (Object[]) invokeLL.objValue;
    }

    public final String h(List<Header> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (Header header : list) {
                    if (header != null && ((String) h.a(16777217, 0, 0L, "844bb2", new byte[]{49, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 83, 2, 16, 41, 52, 18, 108, 54})).equalsIgnoreCase(header.getName())) {
                        return header.getValue();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x038b A[Catch: all -> 0x03af, TryCatch #6 {all -> 0x03af, blocks: (B:51:0x0367, B:53:0x038b, B:55:0x0395), top: B:84:0x0367 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03a0 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object[] i(String str, byte[] bArr, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        SsResponse ssResponse;
        InputStream inputStream;
        Call<TypedInput> call;
        OutputStream outputStream;
        int i2;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, bArr, str2, str3, Boolean.valueOf(z)})) == null) {
            j.a aVar = new j.a();
            try {
                ArrayList arrayList = new ArrayList();
                String str4 = (String) h.a(16777217, 0, 0L, "f91351", new byte[]{84, 52, 77, 76, 3, Base64.INTERNAL_PADDING});
                StringBuilder sb = new StringBuilder();
                sb.append((String) h.a(16777217, 0, 0L, "6eb66f", new byte[]{52, 98, 2, 81, 0, 126, 59, 77, 55, 59}));
                sb.append(str2);
                arrayList.add(new Header(str4, sb.toString()));
                arrayList.add(new Header((String) h.a(16777217, 0, 0L, "3e8714", new byte[]{3, 100, 72, 70, 30, 55}), (String) h.a(16777217, 0, 0L, "e727ec", new byte[]{62, 122, 11})));
                arrayList.add(new Header((String) h.a(16777217, 0, 0L, "3ecd4d", new byte[]{23, 116, 21, 2, 70, 82, 55, 65, 60, 32}), (String) h.a(16777217, 0, 0L, "bc9622", new byte[]{81, 120, 94, 71, 41, 36, 111, 65, 109, 43, 94, 82, 121, 102, 38})));
                arrayList.add(new Header((String) h.a(16777217, 0, 0L, "63d015", new byte[]{4, 62, 25, 80, 11, 44, PublicSuffixDatabase.EXCEPTION_MARKER, 95, 1, 121, 55, 52}), (String) h.a(16777217, 0, 0L, "a7ec76", new byte[]{113, 37, 6, 27, 1, 34, 99, 2, 61, 60, 126, 122, 25, 20, 28, 36, 118, 91, 39, 39, 98, 48, 23, 26})));
                InterfaceC1442a interfaceC1442a = (InterfaceC1442a) RetrofitUtils.getSsRetrofit(str).create(InterfaceC1442a.class);
                call = z ? interfaceC1442a.a(str, arrayList, new TypedByteArray((String) h.a(16777217, 0, 0L, "32151b", new byte[]{Base64.INTERNAL_PADDING, 32, 82, 77, 7, 118, 49, 7, 105, 106, 44, ByteCompanionObject.MAX_VALUE, 77, 66, 26, 112, 36, 94, 115, 113, 48, 53, 67, 76}), bArr, new String[0])) : interfaceC1442a.b(str, arrayList);
                try {
                    aVar.a(str);
                    ssResponse = call.execute();
                } catch (Throwable unused) {
                    ssResponse = null;
                }
                try {
                    i2 = ssResponse.code();
                } catch (Throwable unused2) {
                    i2 = -1;
                    inputStream = null;
                    outputStream = null;
                    try {
                        String str5 = (String) h.a(16777217, 0, 0L, "d4be89", new byte[]{97, 62, 18, 46, 15, 63});
                        aVar.b(ssResponse != null ? h(ssResponse.headers()) : null, i2);
                        bArr2 = null;
                        return new Object[]{String.valueOf(i2), bArr2};
                    } finally {
                        StreamParser.safeClose(inputStream);
                        StreamParser.safeClose(outputStream);
                        if (call != null) {
                            call.cancel();
                        }
                    }
                }
                try {
                    aVar.c(h(ssResponse.headers()), i2);
                    outputStream = str3 != null ? new FileOutputStream(str3) : new ByteArrayOutputStream();
                    try {
                        inputStream = ((TypedInput) ssResponse.body()).in();
                    } catch (Throwable unused3) {
                        inputStream = null;
                    }
                } catch (Throwable unused4) {
                    inputStream = null;
                    outputStream = null;
                    String str52 = (String) h.a(16777217, 0, 0L, "d4be89", new byte[]{97, 62, 18, 46, 15, 63});
                    aVar.b(ssResponse != null ? h(ssResponse.headers()) : null, i2);
                    bArr2 = null;
                    return new Object[]{String.valueOf(i2), bArr2};
                }
            } catch (Throwable unused5) {
                ssResponse = null;
                inputStream = null;
                call = null;
                outputStream = null;
                i2 = -1;
            }
            try {
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr3, 0, 1024);
                    if (read <= 0) {
                        break;
                    }
                    outputStream.write(bArr3, 0, read);
                }
                outputStream.flush();
                bArr2 = outputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) outputStream).toByteArray() : null;
                StreamParser.safeClose(inputStream);
                StreamParser.safeClose(outputStream);
                call.cancel();
            } catch (Throwable unused6) {
                String str522 = (String) h.a(16777217, 0, 0L, "d4be89", new byte[]{97, 62, 18, 46, 15, 63});
                aVar.b(ssResponse != null ? h(ssResponse.headers()) : null, i2);
                bArr2 = null;
                return new Object[]{String.valueOf(i2), bArr2};
            }
            return new Object[]{String.valueOf(i2), bArr2};
        }
        return (Object[]) invokeCommon.objValue;
    }
}
