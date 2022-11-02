package com.baidu.nadcore.video.plugin.videoplayer.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;
        public JSONObject d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
        public Object k;
        public Object l;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.b = "";
            this.c = "";
            this.d = null;
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "detail";
            this.j = -1;
            this.k = null;
        }

        public b(BdVideoAd bdVideoAd) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoAd};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bdVideoAd.suffixAdEnable;
            this.b = bdVideoAd.tpl;
            this.c = bdVideoAd.pd;
            this.d = bdVideoAd.extRequest;
            this.e = bdVideoAd.page;
            this.f = bdVideoAd.type;
            this.g = bdVideoAd.channelId;
            this.h = bdVideoAd.channelTitle;
            this.i = bdVideoAd.source;
            this.j = bdVideoAd.pos;
            this.k = bdVideoAd.mAdVideoTailFrameData;
            this.l = bdVideoAd.userInfoData;
        }

        public BdVideoAd a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new BdVideoAd(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
            }
            return (BdVideoAd) invokeV.objValue;
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
    }

    public BdVideoAd(boolean z, String str, String str2, JSONObject jSONObject, String str3, String str4, String str5, String str6, String str7, int i, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), str, str2, jSONObject, str3, str4, str5, str6, str7, Integer.valueOf(i), obj, obj2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.pos = i;
        this.mAdVideoTailFrameData = obj;
        this.userInfoData = obj2;
    }

    public /* synthetic */ BdVideoAd(boolean z, String str, String str2, JSONObject jSONObject, String str3, String str4, String str5, String str6, String str7, int i, Object obj, Object obj2, a aVar) {
        this(z, str, str2, jSONObject, str3, str4, str5, str6, str7, i, obj, obj2);
    }

    public b builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new b(this);
        }
        return (b) invokeV.objValue;
    }
}
