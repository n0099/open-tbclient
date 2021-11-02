package b.a.p0.a.u.e.e;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.u.c.d;
import b.a.p0.a.u.h.b;
import b.a.p0.a.v2.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0385a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8094a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8095b;

        public C0385a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8095b = aVar;
            this.f8094a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                if (d.f8000c) {
                    String str = "resultCode:" + i2;
                }
                this.f8095b.d(this.f8094a, new b(0));
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
                return !TextUtils.isEmpty(contentTypeFor) ? contentTypeFor : "*/*";
            }
            return "*/*";
        }
        return (String) invokeL.objValue;
    }

    public b r(String str) {
        InterceptResult invokeL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "handle: " + str;
            }
            if (k()) {
                b.a.p0.a.e0.d.b("Api-Base", "Api-Base does not supported when app is invisible.");
                return new b(1001, "Api-Base does not supported when app is invisible.");
            }
            Pair<b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b bVar = (b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("filePath");
            String M = b.a.p0.a.k2.b.M(optString, e.U());
            if (!TextUtils.isEmpty(optString) && b.a.p0.a.k2.b.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    b.a.p0.a.e0.d.b("Api-Base", "cb is required");
                    return new b(202, "cb is required");
                }
                File file = new File(M);
                if (file.exists() && !file.isDirectory()) {
                    SwanAppActivity activity = f.T().getActivity();
                    if (activity == null) {
                        b.a.p0.a.e0.d.b("Api-Base", "activity null");
                        return new b(1001, "activity null");
                    }
                    ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                    Intent intent = new Intent();
                    if (b.a.p0.a.v2.d.i()) {
                        fromFile = s0.a(activity, file);
                        intent.setFlags(3);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", fromFile);
                    intent.setType(q(M));
                    resultDispatcher.addConsumer(new C0385a(this, optString2));
                    resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                    return new b(0);
                }
                b.a.p0.a.e0.d.b("Api-Base", "file not exists");
                return new b(1001, "file not exists");
            }
            b.a.p0.a.e0.d.b("Api-Base", "a valid filePath is required");
            return new b(202, "a valid filePath is required");
        }
        return (b) invokeL.objValue;
    }
}
