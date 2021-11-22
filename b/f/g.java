package b.f;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import b.f.j;
import b.f.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f32000a;

    /* renamed from: b  reason: collision with root package name */
    public int f32001b;

    /* renamed from: c  reason: collision with root package name */
    public int f32002c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Ssp> f32003d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<l> f32004e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<j> f32005f;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32003d = new HashSet();
        this.f32004e = new HashSet();
        this.f32005f = new HashSet();
    }

    public final void a() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.f32000a;
            int i2 = this.f32001b;
            int i3 = this.f32002c;
            c cVar = new c(this.f32003d, this.f32004e, this.f32005f);
            Object obj = v.f32105a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                cVar.srzable(objectOutputStream);
                objectOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                bArr = null;
            }
            String encodeToString = bArr != null ? Base64.encodeToString(bArr, 0) : null;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(encodeToString == null ? -1 : encodeToString.length());
            LogPrinter.v("sspsUTF len:%d", objArr);
            v.f32106b.edit().putLong("key_config_v", j).putInt("key_config_interval", i2).putInt("key_V", i3).putString("key_adcfg", encodeToString).apply();
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                c(str);
                LogPrinter.v("Config cfgv:%d parsed over.", Long.valueOf(this.f32000a));
                if (d()) {
                    a();
                    LogPrinter.v("Config cfgv:%d persisted over.", Long.valueOf(this.f32000a));
                    return true;
                }
            } catch (JSONException e2) {
                LogPrinter.e(e2);
            }
            this.f32003d.clear();
            this.f32004e.clear();
            this.f32005f.clear();
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public void c(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            this.f32000a = NumberUtils.adjustLong(jSONObject2.getLong("ver"), 0L);
            this.f32001b = NumberUtils.adjustInt(jSONObject2.getInt("interval"), 1, 1440);
            this.f32002c = NumberUtils.adjustInt(jSONObject2.optInt("V", 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Ssp ssp = new Ssp(jSONArray.getJSONObject(i2));
                for (Ssp.Pid pid : ssp.pids) {
                    hashMap.put(Long.valueOf(pid.id), pid);
                }
                this.f32003d.add(ssp);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray(Config.SID);
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                this.f32004e.add(new l(jSONArray2.getJSONObject(i3), hashMap));
            }
            if (this.f32002c < 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                this.f32005f.add(new j(optJSONArray.getJSONObject(i4), hashMap));
            }
        }
    }

    @VisibleForTesting
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Ssp ssp : this.f32003d) {
                if (hashSet.contains(ssp.type)) {
                    LogPrinter.e("Duplicate ssp:type(%s) found.", ssp.type);
                    return false;
                }
                hashSet.add(ssp.type);
                for (Ssp.Pid pid : ssp.pids) {
                    if (hashSet2.contains(Long.valueOf(pid.id))) {
                        LogPrinter.e("Duplicate pid(%d) found.", Long.valueOf(pid.id));
                        return false;
                    }
                    hashSet2.add(Long.valueOf(pid.id));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (l lVar : this.f32004e) {
                if (hashSet3.contains(lVar.f32044a)) {
                    LogPrinter.e("Duplicate sid(%s) found in SlotId", lVar.f32044a);
                    return false;
                }
                hashSet3.add(lVar.f32044a);
                for (l.b bVar : lVar.f32048e) {
                    HashSet hashSet4 = new HashSet();
                    for (l.a aVar : bVar.f32054b) {
                        if (!hashSet2.contains(Long.valueOf(aVar.f32049a))) {
                            LogPrinter.e("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar.f32049a));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(aVar.f32049a))) {
                            LogPrinter.e("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar.f32049a), lVar.f32044a);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(aVar.f32049a));
                        }
                    }
                }
            }
            if (this.f32002c == 2) {
                for (j jVar : this.f32005f) {
                    if (hashSet3.contains(jVar.f32026a)) {
                        LogPrinter.e("Duplicate sid(%s) found in SerialSlotId.", jVar.f32026a);
                        return false;
                    }
                    hashSet3.add(jVar.f32026a);
                    for (j.b bVar2 : jVar.f32027b) {
                        for (j.a aVar2 : bVar2.f32033b) {
                            if (!hashSet2.contains(Long.valueOf(aVar2.f32029a))) {
                                LogPrinter.e("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar2.f32029a));
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
