package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.container.AllInOneXAdContainerFactory;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdContainerFactoryBuilder {
    public static final String TAG = "ContainerFactoryBuilder";
    public static IXAdContainerFactory mAdContainerFactoryInstance;
    public Context mContext;
    public double mApkVersion = 0.1d;
    public XAdLogger mAdLogger = XAdLogger.getInstance();

    public XAdContainerFactoryBuilder(Context context) {
        this.mContext = context;
    }

    public IXAdContainerFactory getXAdContainerFactoryInstance() throws IllegalAccessException {
        if (mAdContainerFactoryInstance == null) {
            try {
                mAdContainerFactoryInstance = new AllInOneXAdContainerFactory(this.mContext);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p_ver", "9.041");
                mAdContainerFactoryInstance.initConfig(jSONObject);
                this.mApkVersion = mAdContainerFactoryInstance.getRemoteVersion();
                mAdContainerFactoryInstance.onTaskDistribute("permission_module", MobadsPermissionSettings.getPermissionInfo());
                mAdContainerFactoryInstance.initCommonModuleObj(FoundationFacadeUtils.getInstance());
            } catch (Throwable th) {
                this.mAdLogger.w(TAG, th.getMessage());
                throw new IllegalAccessException("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return mAdContainerFactoryInstance;
    }

    public void resetXAdContainerFactoryInstance() {
        mAdContainerFactoryInstance = null;
    }
}
