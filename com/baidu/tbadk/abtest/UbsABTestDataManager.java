package com.baidu.tbadk.abtest;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.abtest.group.AuthVideoIconABTest;
import com.baidu.tbadk.abtest.group.BdNetABTest;
import com.baidu.tbadk.abtest.group.ConcernForumCardUbsABTest;
import com.baidu.tbadk.abtest.group.EmotionABTest;
import com.baidu.tbadk.abtest.group.FirstLoginABTest;
import com.baidu.tbadk.abtest.group.FrsNewAreaTabSortUbsABTest;
import com.baidu.tbadk.abtest.group.FrsTabLocationUbsABTest;
import com.baidu.tbadk.abtest.group.GetFrsFunAdPreLoadABTest;
import com.baidu.tbadk.abtest.group.HomeElasticABTest;
import com.baidu.tbadk.abtest.group.HomeGroupUbsABTest;
import com.baidu.tbadk.abtest.group.HomePagePromoteLoginUbsABTest;
import com.baidu.tbadk.abtest.group.HomeRecommendLoadMoreTest;
import com.baidu.tbadk.abtest.group.HttpsABTest;
import com.baidu.tbadk.abtest.group.ImageViewerABTest;
import com.baidu.tbadk.abtest.group.InduceSharingABTest;
import com.baidu.tbadk.abtest.group.InteractionAlaLiveCardUbsABTest;
import com.baidu.tbadk.abtest.group.LaunchUpABTest;
import com.baidu.tbadk.abtest.group.PBCacheBlockABTest;
import com.baidu.tbadk.abtest.group.PbSubABTest;
import com.baidu.tbadk.abtest.group.PlgRequestLimitABTest;
import com.baidu.tbadk.abtest.group.RecommendBarUbsABTest;
import com.baidu.tbadk.abtest.group.SearchLoginUbsABTest;
import com.baidu.tbadk.abtest.group.StaticOptABTest;
import com.baidu.tbadk.abtest.group.StyleAlaLiveCardUbsABTest;
import com.baidu.tbadk.abtest.group.TbNetABTest;
import com.baidu.tbadk.abtest.group.TbVideoPlayerABTest;
import com.baidu.tbadk.abtest.group.ThreadCardGroupUbsABTest;
import com.baidu.tbadk.abtest.group.TiebaPlusCardModelABTest;
import com.baidu.tbadk.abtest.group.VideoAdDrawUbsABTest;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.b55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbsABTestDataManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREF_KEY_SWITCHS = "ubs_abtest_config";
    public static UbsABTestDataManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<BdUniqueId, AbsGroupUbsABTest> mAbTestGroups;
    public final HashMap<String, UsbAbTestSwitch> mSwitchs;
    public final HashMap<BdUniqueId, UsbAbTestSwitch> mUbsABTestMap;

    public static String getSharedPrefKeyForUbsABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? PREF_KEY_SWITCHS : (String) invokeV.objValue;
    }

    public UbsABTestDataManager() {
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
        this.mSwitchs = new HashMap<>();
        this.mAbTestGroups = new HashMap<>();
        this.mUbsABTestMap = new HashMap<>();
        registerABTestGroup();
        putAllUsbAbTest(getAllDataFormSharedPref());
    }

    private void putUsbAbTestForAllGroup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            for (Map.Entry<BdUniqueId, AbsGroupUbsABTest> entry : this.mAbTestGroups.entrySet()) {
                AbsGroupUbsABTest value = entry.getValue();
                if (value != null) {
                    setUbsABTestForGroup(value);
                }
            }
            refreshUbsABTestMap();
        }
    }

    private void refreshUbsABTestMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mUbsABTestMap.clear();
            for (BdUniqueId bdUniqueId : this.mAbTestGroups.keySet()) {
                this.mUbsABTestMap.put(bdUniqueId, getUbsABTestByGroupKey(bdUniqueId));
            }
        }
    }

    public HashMap<String, Integer> getSwitchsClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int i = 0;
            for (String str : this.mSwitchs.keySet()) {
                hashMap.put(str, Integer.valueOf(i));
                i++;
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    private void afterSyncResultAbtest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            b55.m().z("static_opt_open", UbsABTestHelper.isStaticOptTest() ? 1 : 0);
        }
    }

    public static UbsABTestDataManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mInstance == null) {
                synchronized (UbsABTestDataManager.class) {
                    if (mInstance == null) {
                        mInstance = new UbsABTestDataManager();
                    }
                }
            }
            return mInstance;
        }
        return (UbsABTestDataManager) invokeV.objValue;
    }

    public Map<BdUniqueId, UsbAbTestSwitch> getUbsABTestMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mUbsABTestMap;
        }
        return (Map) invokeV.objValue;
    }

    private HashMap<String, UsbAbTestSwitch> getAllDataFormSharedPref() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            HashMap<String, UsbAbTestSwitch> hashMap = new HashMap<>();
            try {
                getSharedPrefKeyForUbsABTest();
                JSONArray jSONArray = new JSONArray(b55.m().s(getSharedPrefKeyForUbsABTest(), "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("sid");
                        hashMap.put(optString, new UsbAbTestSwitch(optString));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    private void putAllUsbAbTest(HashMap<String, UsbAbTestSwitch> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, hashMap) == null) {
            synchronized (this.mSwitchs) {
                this.mSwitchs.clear();
                if (hashMap != null) {
                    this.mSwitchs.putAll(hashMap);
                }
                putUsbAbTestForAllGroup();
            }
        }
    }

    public synchronized UsbAbTestSwitch getABTestSwitchData(String str) {
        InterceptResult invokeL;
        UsbAbTestSwitch usbAbTestSwitch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                usbAbTestSwitch = this.mSwitchs.get(str);
            }
            return usbAbTestSwitch;
        }
        return (UsbAbTestSwitch) invokeL.objValue;
    }

    public UsbAbTestSwitch getUbsABTestByGroupKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            AbsGroupUbsABTest absGroupUbsABTest = this.mAbTestGroups.get(bdUniqueId);
            if (absGroupUbsABTest == null) {
                return null;
            }
            return absGroupUbsABTest.getCurrentUsbAbTest();
        }
        return (UsbAbTestSwitch) invokeL.objValue;
    }

    public void parseJSONArrayByStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    parseJSONArray(null);
                } else {
                    parseJSONArray(new JSONArray(str));
                }
            } catch (Exception unused) {
            }
        }
    }

    public void registerABTestGroup(AbsGroupUbsABTest absGroupUbsABTest) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, absGroupUbsABTest) == null) && absGroupUbsABTest != null && absGroupUbsABTest.getGroupKey() != null) {
            this.mAbTestGroups.put(absGroupUbsABTest.getGroupKey(), absGroupUbsABTest);
        }
    }

    private void registerABTestGroup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            registerABTestGroup(new ThreadCardGroupUbsABTest());
            registerABTestGroup(new HomeGroupUbsABTest());
            registerABTestGroup(new RecommendBarUbsABTest());
            registerABTestGroup(new ConcernForumCardUbsABTest());
            registerABTestGroup(new StaticOptABTest());
            registerABTestGroup(new FrsTabLocationUbsABTest());
            registerABTestGroup(new FrsNewAreaTabSortUbsABTest());
            registerABTestGroup(new ImageViewerABTest());
            registerABTestGroup(new SearchLoginUbsABTest());
            registerABTestGroup(new PbSubABTest());
            registerABTestGroup(new HomePagePromoteLoginUbsABTest());
            registerABTestGroup(new FirstLoginABTest());
            registerABTestGroup(new EmotionABTest());
            registerABTestGroup(new GetFrsFunAdPreLoadABTest());
            registerABTestGroup(new VideoAdDrawUbsABTest());
            registerABTestGroup(new InduceSharingABTest());
            registerABTestGroup(new AuthVideoIconABTest());
            registerABTestGroup(new LaunchUpABTest());
            registerABTestGroup(new HomeElasticABTest());
            registerABTestGroup(new TbVideoPlayerABTest());
            registerABTestGroup(new TiebaPlusCardModelABTest());
            registerABTestGroup(new TbNetABTest());
            registerABTestGroup(new PBCacheBlockABTest());
            registerABTestGroup(new BdNetABTest());
            registerABTestGroup(new HttpsABTest());
            registerABTestGroup(new HomeRecommendLoadMoreTest());
            registerABTestGroup(new PlgRequestLimitABTest());
            registerABTestGroup(new StyleAlaLiveCardUbsABTest());
            registerABTestGroup(new InteractionAlaLiveCardUbsABTest());
        }
    }

    private void setUbsABTestForGroup(AbsGroupUbsABTest absGroupUbsABTest) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, this, absGroupUbsABTest) != null) || absGroupUbsABTest == null) {
            return;
        }
        ArrayList<String> aBTestKeys = absGroupUbsABTest.getABTestKeys();
        UsbAbTestSwitch usbAbTestSwitch = null;
        if (ListUtils.isEmpty(aBTestKeys)) {
            absGroupUbsABTest.setCurrentUsbAbTest(null);
            return;
        }
        Iterator<String> it = aBTestKeys.iterator();
        while (it.hasNext()) {
            usbAbTestSwitch = this.mSwitchs.get(it.next());
            if (usbAbTestSwitch != null) {
                break;
            }
        }
        absGroupUbsABTest.setCurrentUsbAbTest(usbAbTestSwitch);
    }

    public void parseJSONArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) {
            try {
                String sharedPrefKeyForUbsABTest = getSharedPrefKeyForUbsABTest();
                if (jSONArray == null) {
                    this.mSwitchs.clear();
                    b55.m().H(sharedPrefKeyForUbsABTest);
                    return;
                }
                HashMap<String, UsbAbTestSwitch> hashMap = new HashMap<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("sid");
                        hashMap.put(optString, new UsbAbTestSwitch(optString));
                    }
                }
                putAllUsbAbTest(hashMap);
                b55.m().B(sharedPrefKeyForUbsABTest, jSONArray.toString());
                afterSyncResultAbtest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchCurrentABTestBySid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this.mSwitchs) {
                if (TextUtils.isEmpty(str)) {
                    this.mSwitchs.clear();
                    b55.m().H(getSharedPrefKeyForUbsABTest());
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sid", str);
                    jSONArray.put(jSONObject);
                    String jSONArray2 = jSONArray.toString();
                    b55.m().B(getSharedPrefKeyForUbsABTest(), jSONArray2);
                    HashMap<String, UsbAbTestSwitch> hashMap = new HashMap<>(1);
                    hashMap.put(str, new UsbAbTestSwitch(str));
                    putAllUsbAbTest(hashMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
