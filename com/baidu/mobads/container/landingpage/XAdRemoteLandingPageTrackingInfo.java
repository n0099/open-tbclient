package com.baidu.mobads.container.landingpage;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class XAdRemoteLandingPageTrackingInfo extends XAdRemoteAbstractTrackingInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] actionBarClks;
    public long duration;
    public int e75;
    public int e753;
    public int from;
    public int height;
    public long lpWebFinishLoad;
    public long lpWebStartLoad;
    public int lploadtime;
    public long luAdaFinish;
    public int luAdaProtocol;
    public long luAdaStart;
    public String luAdenUrl;
    public long luBdScFinish;
    public int luBdScProtocol;
    public long luBdScStart;
    public long luBdUrlFinish;
    public int luBdUrlProtocol;
    public long luBdUrlStart;
    public long luPageFinish;
    public long luPageStart;
    public int luProtocol;
    public long luSslErrorTime;
    public int mButtonClickBottomCancel;
    public int mButtonClickBottomCopyUrl;
    public int mButtonClickBottomRefresh;
    public int mButtonClickOsGoBack;
    public int mButtonClickOsHome;
    public int mButtonClickTopGoBack;
    public int mButtonClickTopThreePoint;
    public AtomicInteger mMoveTimes;
    public int maxTabs;
    public String obj;
    public int order;
    public int progress;
    public String shoubailp;
    public int urlclicks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteLandingPageTrackingInfo(XAdRemoteCommandExtraInfo xAdRemoteCommandExtraInfo) {
        super(xAdRemoteCommandExtraInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdRemoteCommandExtraInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdRemoteCommandExtraInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.luPageStart = -1L;
        this.luPageFinish = -1L;
        this.luProtocol = -1;
        this.luBdUrlStart = -1L;
        this.luBdUrlFinish = -1L;
        this.luBdUrlProtocol = -1;
        this.luBdScStart = -1L;
        this.luBdScFinish = -1L;
        this.luBdScProtocol = -1;
        this.luAdaStart = -1L;
        this.luAdaFinish = -1L;
        this.luAdaProtocol = -1;
        this.luSslErrorTime = -1L;
        this.mMoveTimes = new AtomicInteger(0);
        this.lpWebStartLoad = 0L;
        this.lpWebFinishLoad = 0L;
        this.mButtonClickTopGoBack = 0;
        this.mButtonClickTopThreePoint = 0;
        this.mButtonClickBottomRefresh = 0;
        this.mButtonClickBottomCopyUrl = 0;
        this.mButtonClickBottomCancel = 0;
        this.mButtonClickOsGoBack = 0;
        this.mButtonClickOsHome = 0;
    }

    @Override // com.baidu.mobads.container.landingpage.XAdRemoteAbstractTrackingInfo
    public HashMap<String, String> toAdditionalHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            String str = this.obj;
            if (str != null && str.length() > 1024) {
                hashMap.put("obj", this.obj.substring(0, 1023));
            } else {
                hashMap.put("obj", this.obj);
            }
            hashMap.put(IMConstants.SERVICE_TYPE_ORDER, "" + this.order);
            hashMap.put("height", "" + this.height);
            hashMap.put("progress", "" + this.progress);
            hashMap.put("moves", "" + this.mMoveTimes.get());
            hashMap.put("clicks", "" + this.urlclicks);
            hashMap.put("urlclicks", "" + this.urlclicks);
            hashMap.put("lploadtime", "" + this.lploadtime);
            hashMap.put("duration", "" + this.duration);
            hashMap.put("_lpWebStartLoad", "" + this.lpWebStartLoad);
            hashMap.put("_lpWebFinishLoad", "" + this.lpWebFinishLoad);
            if (this.luPageStart > -1) {
                hashMap.put("luStart", "" + this.luPageStart);
                hashMap.put("luFinish", "" + this.luPageFinish);
                hashMap.put("luProtocol", "" + this.luProtocol);
                hashMap.put("bdScStart", "" + this.luBdScStart);
                hashMap.put("bdScFinish", "" + this.luBdScFinish);
                hashMap.put("bdScProtocol", "" + this.luBdScProtocol);
                hashMap.put("bdUrlStart", "" + this.luBdUrlStart);
                hashMap.put("bdUrlFinish", "" + this.luBdUrlFinish);
                hashMap.put("bdUrlProtocol", "" + this.luBdUrlProtocol);
                hashMap.put("adaStart", "" + this.luAdaStart);
                hashMap.put("adaFinish", "" + this.luAdaFinish);
                hashMap.put("adaProtocol", "" + this.luAdaProtocol);
                hashMap.put("luSslError", "" + this.luSslErrorTime);
            }
            hashMap.put("e75", "" + this.e75);
            hashMap.put("e75_3", "" + this.e753);
            hashMap.put("from", "" + this.from);
            hashMap.put("maxTabs", "" + this.maxTabs);
            hashMap.put("b_cancel", "" + this.mButtonClickBottomCancel);
            hashMap.put("b_refresh", "" + this.mButtonClickBottomRefresh);
            hashMap.put("b_copy", "" + this.mButtonClickBottomCopyUrl);
            hashMap.put("b_goback", "" + this.mButtonClickTopGoBack);
            hashMap.put("b_threeP", "" + this.mButtonClickTopThreePoint);
            hashMap.put("b_home", "" + this.mButtonClickOsHome);
            hashMap.put("b_osgoback", "" + this.mButtonClickOsGoBack);
            hashMap.put("shoubailp", this.shoubailp);
            hashMap.put(HttpConstants.HTTP_HARDWARE, "open");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
