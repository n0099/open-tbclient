package c.g;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import c.g.j;
import c.g.l;
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
/* loaded from: classes3.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f28474b;

    /* renamed from: c  reason: collision with root package name */
    public int f28475c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Ssp> f28476d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<l> f28477e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<j> f28478f;

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
        this.f28476d = new HashSet();
        this.f28477e = new HashSet();
        this.f28478f = new HashSet();
    }

    public final void a() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j2 = this.a;
            int i2 = this.f28474b;
            int i3 = this.f28475c;
            c cVar = new c(this.f28476d, this.f28477e, this.f28478f);
            Object obj = a0.a;
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
            a0.f28234b.edit().putLong("key_config_v", j2).putInt("key_config_interval", i2).putInt("key_V", i3).putString("key_adcfg", encodeToString).apply();
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
                LogPrinter.v("Config cfgv:%d parsed over.", Long.valueOf(this.a));
                if (d()) {
                    a();
                    LogPrinter.v("Config cfgv:%d persisted over.", Long.valueOf(this.a));
                    return true;
                }
            } catch (JSONException e2) {
                LogPrinter.e(e2);
            }
            this.f28476d.clear();
            this.f28477e.clear();
            this.f28478f.clear();
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
            this.a = NumberUtils.adjustLong(jSONObject2.getLong("ver"), 0L);
            this.f28474b = NumberUtils.adjustInt(jSONObject2.getInt("interval"), 1, 1440);
            this.f28475c = NumberUtils.adjustInt(jSONObject2.optInt("V", 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Ssp ssp = new Ssp(jSONArray.getJSONObject(i2));
                for (Ssp.Pid pid : ssp.pids) {
                    hashMap.put(Long.valueOf(pid.id), pid);
                }
                this.f28476d.add(ssp);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray(Config.SID);
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                this.f28477e.add(new l(jSONArray2.getJSONObject(i3), hashMap));
            }
            if (this.f28475c < 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                this.f28478f.add(new j(optJSONArray.getJSONObject(i4), hashMap));
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
            for (Ssp ssp : this.f28476d) {
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
            for (l lVar : this.f28477e) {
                if (hashSet3.contains(lVar.a)) {
                    LogPrinter.e("Duplicate sid(%s) found in SlotId", lVar.a);
                    return false;
                }
                hashSet3.add(lVar.a);
                for (l.b bVar : lVar.f28496e) {
                    HashSet hashSet4 = new HashSet();
                    for (l.a aVar : bVar.f28500b) {
                        if (!hashSet2.contains(Long.valueOf(aVar.a))) {
                            LogPrinter.e("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar.a));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(aVar.a))) {
                            LogPrinter.e("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar.a), lVar.a);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(aVar.a));
                        }
                    }
                }
            }
            if (this.f28475c == 2) {
                for (j jVar : this.f28478f) {
                    if (hashSet3.contains(jVar.a)) {
                        LogPrinter.e("Duplicate sid(%s) found in SerialSlotId.", jVar.a);
                        return false;
                    }
                    hashSet3.add(jVar.a);
                    for (j.b bVar2 : jVar.f28487b) {
                        for (j.a aVar2 : bVar2.f28491b) {
                            if (!hashSet2.contains(Long.valueOf(aVar2.a))) {
                                LogPrinter.e("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar2.a));
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
