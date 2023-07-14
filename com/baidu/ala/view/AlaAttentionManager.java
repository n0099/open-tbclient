package com.baidu.ala.view;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class AlaAttentionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ATTENTION_REQUEST_MAP_MAX_SIZE = 3;
    public static AlaAttentionManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, AttentionAsyncTask> mAttentionTaskMap;
    public HashMap<String, LinkedList<AlaAttentionData>> mUserAttentionRequestMap;

    /* renamed from: com.baidu.ala.view.AlaAttentionManager$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class AttentionAsyncTask extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String forumId;
        public String from;
        public String inLive;
        public boolean isAttention;
        public boolean isGod;
        public NetWork mNetwork;
        public BdUniqueId pageId;
        public String portrait;
        public boolean showToastAfterAttentionSuc;
        public final /* synthetic */ AlaAttentionManager this$0;
        public String toUid;

        public AttentionAsyncTask(AlaAttentionManager alaAttentionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAttentionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = alaAttentionManager;
            this.mNetwork = null;
            this.isGod = false;
            this.from = "0";
            this.inLive = "0";
            this.forumId = null;
            this.showToastAfterAttentionSuc = false;
        }

        public /* synthetic */ AttentionAsyncTask(AlaAttentionManager alaAttentionManager, AnonymousClass1 anonymousClass1) {
            this(alaAttentionManager);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.mNetwork;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.mNetwork = null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, numArr)) == null) {
                try {
                    if (this.portrait != null) {
                        NetWork netWork = new NetWork();
                        this.mNetwork = netWork;
                        if (this.isAttention) {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                            this.mNetwork.setNeedSig(true);
                        } else {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                        }
                        this.mNetwork.addPostData("portrait", this.portrait);
                        if (!StringUtils.isNull(this.from)) {
                            this.mNetwork.addPostData("from_type", this.from);
                        }
                        if (!StringUtils.isNull(this.forumId)) {
                            this.mNetwork.addPostData("forum_id", this.forumId);
                        }
                        this.mNetwork.addPostData("in_live", this.inLive);
                        this.mNetwork.getNetContext().getRequest().mIsNeedTbs = true;
                        return this.mNetwork.postNetData();
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((AttentionAsyncTask) str);
                if (this.mNetwork != null) {
                    UpdateAttentionMessage.b bVar = new UpdateAttentionMessage.b();
                    bVar.a = this.mNetwork.getNetContext().getResponse().isRequestSuccess();
                    bVar.b = this.mNetwork.getErrorString();
                    bVar.d = this.isAttention;
                    bVar.c = this.toUid;
                    bVar.f = this.isGod;
                    bVar.b(str, this.showToastAfterAttentionSuc);
                    this.mNetwork.getNetContext().getResponse();
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(bVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.pageId));
                    MessageManager.getInstance().dispatchResponsedMessage(updateAttentionMessage);
                }
                this.this$0.mAttentionTaskMap.remove(this.toUid);
                if (this.this$0.mUserAttentionRequestMap.containsKey(this.toUid)) {
                    this.this$0.removeRequestListFirstByUid(this.toUid);
                    this.this$0.executeAttentionTask(this.toUid);
                }
            }
        }

        public void setAlaAttentionData(AlaAttentionData alaAttentionData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, alaAttentionData) == null) {
                this.isAttention = alaAttentionData.isAttention();
                this.toUid = alaAttentionData.getUserId();
                this.portrait = alaAttentionData.getPortrait();
                this.inLive = alaAttentionData.getInLive();
                this.pageId = alaAttentionData.getPageId();
                this.from = alaAttentionData.getFrom();
                this.forumId = alaAttentionData.getForumId();
                this.isGod = alaAttentionData.isGod();
                if (this.forumId != null) {
                    this.showToastAfterAttentionSuc = true;
                }
            }
        }
    }

    public AlaAttentionManager() {
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
        this.mUserAttentionRequestMap = new HashMap<>();
        this.mAttentionTaskMap = new HashMap<>();
    }

    public static AlaAttentionManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (sInstance == null) {
                synchronized (AlaAttentionManager.class) {
                    if (sInstance == null) {
                        sInstance = new AlaAttentionManager();
                    }
                }
            }
            return sInstance;
        }
        return (AlaAttentionManager) invokeV.objValue;
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<AlaAttentionData> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            try {
                linkedList.removeFirst();
            } catch (Exception unused) {
            }
        }
    }

    private void addAttentionReqeustList(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, linkedList, alaAttentionData) != null) || alaAttentionData == null) {
            return;
        }
        linkedList.add(alaAttentionData.m27clone());
    }

    private void dealAttentionUpdateData(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, linkedList, alaAttentionData) == null) {
            if (linkedList.size() < 1) {
                addAttentionReqeustList(linkedList, alaAttentionData);
                return;
            }
            AlaAttentionData last = linkedList.getLast();
            if (last.getPortrait().equals(alaAttentionData.getPortrait()) && last.isAttention() == alaAttentionData.isAttention()) {
                if (!BdLog.isDebugMode()) {
                    return;
                }
                throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
            } else if (linkedList.size() < 3) {
                addAttentionReqeustList(linkedList, alaAttentionData);
            } else if (linkedList.get(1).equals(alaAttentionData)) {
                linkedList.removeLast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAttentionTask(String str) {
        LinkedList<AlaAttentionData> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, str) == null) && !StringUtils.isNull(str) && this.mAttentionTaskMap.get(str) == null && (linkedList = this.mUserAttentionRequestMap.get(str)) != null && linkedList.size() > 0) {
            AttentionAsyncTask attentionAsyncTask = new AttentionAsyncTask(this, null);
            this.mAttentionTaskMap.put(str, attentionAsyncTask);
            attentionAsyncTask.setPriority(2);
            attentionAsyncTask.setAlaAttentionData(linkedList.getFirst());
            attentionAsyncTask.execute(new Integer[0]);
        }
    }

    public void updateAttention(String str, AlaAttentionData alaAttentionData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, alaAttentionData) == null) && !StringUtils.isNull(str) && alaAttentionData != null && alaAttentionData.getPortrait() != null) {
            LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mUserAttentionRequestMap.put(str, linkedList);
            }
            dealAttentionUpdateData(linkedList, alaAttentionData);
            executeAttentionTask(str);
        }
    }
}
