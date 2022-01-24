package com.baidu.nadcore.video.plugin.videoplayer.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BdVideoAd implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_VIDEO_DAPAGE = "da_page";
    public transient /* synthetic */ FieldHolder $fh;
    public String channelId;
    public String channelTitle;
    public JSONObject commonParams;
    public JSONObject extRequest;
    public Object fullItemAdData;
    public Object mAdVideoTailFrameData;
    public String page;
    public String pd;
    public int pos;
    public String source;
    public boolean suffixAdEnable;
    public String tpl;
    public String type;
    public Object userInfoData;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ BdVideoAd(boolean z, String str, String str2, JSONObject jSONObject, String str3, String str4, String str5, String str6, String str7, int i2, Object obj, Object obj2, a aVar) {
        this(z, str, str2, jSONObject, str3, str4, str5, str6, str7, i2, obj, obj2);
    }

    public b builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (b) invokeV.objValue;
    }

    public BdVideoAd(boolean z, String str, String str2, JSONObject jSONObject, String str3, String str4, String str5, String str6, String str7, int i2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), str, str2, jSONObject, str3, str4, str5, str6, str7, Integer.valueOf(i2), obj, obj2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.suffixAdEnable = z;
        this.tpl = str;
        this.pd = str2;
        this.extRequest = jSONObject;
        this.page = str3;
        this.type = str4;
        this.channelId = str5;
        this.channelTitle = str6;
        this.source = str7;
        this.pos = i2;
        this.mAdVideoTailFrameData = obj;
        this.userInfoData = obj2;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f37148b;

        /* renamed from: c  reason: collision with root package name */
        public String f37149c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f37150d;

        /* renamed from: e  reason: collision with root package name */
        public String f37151e;

        /* renamed from: f  reason: collision with root package name */
        public String f37152f;

        /* renamed from: g  reason: collision with root package name */
        public String f37153g;

        /* renamed from: h  reason: collision with root package name */
        public String f37154h;

        /* renamed from: i  reason: collision with root package name */
        public String f37155i;

        /* renamed from: j  reason: collision with root package name */
        public int f37156j;
        public Object k;
        public Object l;

        public b() {
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
            this.a = false;
            this.f37148b = "";
            this.f37149c = "";
            this.f37150d = null;
            this.f37151e = "";
            this.f37152f = "";
            this.f37153g = "";
            this.f37154h = "";
            this.f37155i = "detail";
            this.f37156j = -1;
            this.k = null;
        }

        public BdVideoAd a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new BdVideoAd(this.a, this.f37148b, this.f37149c, this.f37150d, this.f37151e, this.f37152f, this.f37153g, this.f37154h, this.f37155i, this.f37156j, this.k, this.l, null) : (BdVideoAd) invokeV.objValue;
        }

        public b b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.k = obj;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.a = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b(BdVideoAd bdVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoAd};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bdVideoAd.suffixAdEnable;
            this.f37148b = bdVideoAd.tpl;
            this.f37149c = bdVideoAd.pd;
            this.f37150d = bdVideoAd.extRequest;
            this.f37151e = bdVideoAd.page;
            this.f37152f = bdVideoAd.type;
            this.f37153g = bdVideoAd.channelId;
            this.f37154h = bdVideoAd.channelTitle;
            this.f37155i = bdVideoAd.source;
            this.f37156j = bdVideoAd.pos;
            this.k = bdVideoAd.mAdVideoTailFrameData;
            this.l = bdVideoAd.userInfoData;
        }
    }
}
