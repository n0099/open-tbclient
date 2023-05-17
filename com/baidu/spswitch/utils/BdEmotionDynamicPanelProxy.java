package com.baidu.spswitch.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.emotion.adapter.EmotionScrollerVPAdapter;
import com.baidu.spswitch.emotion.bean.BDEmotionDynamicModelKt;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.emotion.net.EmotionRequest;
import com.baidu.spswitch.emotion.net.EmotionRequestCallback;
import com.baidu.spswitch.emotion.view.BDEmotionBaseLayout;
import com.baidu.spswitch.emotion.view.BDEmotionDynamicLayout;
import com.baidu.spswitch.emotion.view.BDEmotionTextLayout;
import com.baidu.spswitch.emotion.view.EmotionTabLayout;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BdEmotionDynamicPanelProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionScrollerVPAdapter mAdapter;
    public Context mContext;
    public BDEmotionPanelManager.EmotionPanelConfig mEmotionPanelConfig;
    public EmotionTabLayout mTabLayout;
    public Map<String, EmotionTypeModel> mTypeModels;

    public BdEmotionDynamicPanelProxy(Context context, EmotionScrollerVPAdapter emotionScrollerVPAdapter, BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, emotionScrollerVPAdapter, emotionPanelConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTypeModels = new LinkedHashMap();
        this.mAdapter = emotionScrollerVPAdapter;
        this.mContext = context;
        this.mEmotionPanelConfig = emotionPanelConfig;
        ExecutorUtilsExt.postOnElastic(new Runnable(this) { // from class: com.baidu.spswitch.utils.BdEmotionDynamicPanelProxy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdEmotionDynamicPanelProxy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.fetchEmotionTabData();
                }
            }
        }, "emotion_dynamic", 1);
    }

    public void setTabLayout(EmotionTabLayout emotionTabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionTabLayout) == null) {
            this.mTabLayout = emotionTabLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createEmotionPanel(Map<String, EmotionTypeModel> map) {
        BDEmotionBaseLayout emotionLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, map) == null) && map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                EmotionTypeModel emotionTypeModel = map.get(str);
                if (!TextUtils.isEmpty(str) && emotionTypeModel != null && !TextUtils.isEmpty(emotionTypeModel.getType()) && (emotionLayout = getEmotionLayout(emotionTypeModel.getType())) != null) {
                    emotionLayout.setEmotionPanelConfig(this.mEmotionPanelConfig);
                    EmotionScrollerVPAdapter emotionScrollerVPAdapter = this.mAdapter;
                    if (emotionScrollerVPAdapter != null) {
                        emotionScrollerVPAdapter.addData(emotionLayout);
                        emotionLayout.loadData(emotionTypeModel);
                    }
                }
            }
            EmotionTabLayout emotionTabLayout = this.mTabLayout;
            if (emotionTabLayout != null) {
                emotionTabLayout.changeTabByTabId(emotionTabLayout.getSelectedTabId());
                this.mTabLayout.setPanelConfig(this.mEmotionPanelConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEmotionTabResult(@Nullable String str) {
        EmotionTypeModel parseEmotionTabModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("errno");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                this.mTypeModels.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && (parseEmotionTabModel = BDEmotionDynamicModelKt.parseEmotionTabModel(optJSONObject)) != null && parseEmotionTabModel.isValid()) {
                        this.mTypeModels.put(parseEmotionTabModel.getId(), parseEmotionTabModel);
                    }
                }
                if (!this.mTypeModels.isEmpty()) {
                    UiThreadUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.spswitch.utils.BdEmotionDynamicPanelProxy.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BdEmotionDynamicPanelProxy this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (this.this$0.mTabLayout != null) {
                                    this.this$0.mTabLayout.addData(this.this$0.mTypeModels);
                                }
                                BdEmotionDynamicPanelProxy bdEmotionDynamicPanelProxy = this.this$0;
                                bdEmotionDynamicPanelProxy.createEmotionPanel(bdEmotionDynamicPanelProxy.mTypeModels);
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchEmotionTabData() {
        BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || (emotionPanelConfig = this.mEmotionPanelConfig) == null) {
            return;
        }
        EmotionRequest.getEmoIdList(emotionPanelConfig.nid, new EmotionRequestCallback(this) { // from class: com.baidu.spswitch.utils.BdEmotionDynamicPanelProxy.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdEmotionDynamicPanelProxy this$0;

            @Override // com.baidu.spswitch.emotion.net.EmotionRequestCallback
            public void onFailure(@Nullable String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.spswitch.emotion.net.EmotionRequestCallback
            public void onSuccess(String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) {
                    return;
                }
                this.this$0.handleEmotionTabResult(str);
            }
        });
    }

    public EmotionScrollerVPAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdapter;
        }
        return (EmotionScrollerVPAdapter) invokeV.objValue;
    }

    private BDEmotionBaseLayout getEmotionLayout(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                return new BDEmotionDynamicLayout(this.mContext);
            }
            if (TextUtils.equals(str, "2")) {
                return new BDEmotionTextLayout(this.mContext);
            }
            return null;
        }
        return (BDEmotionBaseLayout) invokeL.objValue;
    }
}
