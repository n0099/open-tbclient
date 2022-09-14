package com.baidu.ala.view;

import android.text.TextUtils;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.au4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.lo4;
import com.baidu.tieba.r9;
import com.baidu.tieba.x15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaAttentionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALA_LIVE_PUSH_REMIND_TIME_INTERVAL = 86400000;
    public static final int ATTENTION_REQUEST_MAP_MAX_SIZE = 3;
    public static AlaAttentionManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, AttentionAsyncTask> mAttentionTaskMap;
    public HashMap<String, LinkedList<AlaAttentionData>> mUserAttentionRequestMap;

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
                    UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                    aVar.a = this.mNetwork.getNetContext().getResponse().isRequestSuccess();
                    aVar.b = this.mNetwork.getErrorString();
                    aVar.d = this.isAttention;
                    aVar.c = this.toUid;
                    aVar.f = this.isGod;
                    aVar.b(str, this.showToastAfterAttentionSuc);
                    aVar.g = this.mNetwork.getNetContext().getResponse();
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
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

    private void addAttentionReqeustList(LinkedList<AlaAttentionData> linkedList, AlaAttentionData alaAttentionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, linkedList, alaAttentionData) == null) || alaAttentionData == null) {
            return;
        }
        linkedList.add(alaAttentionData.m26clone());
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
                if (BdLog.isDebugMode()) {
                    throw new IllegalArgumentException("new attention data is the same as the nearest attention data");
                }
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
        if (!(interceptable == null || interceptable.invokeL(65542, this, str) == null) || StringUtils.isNull(str) || this.mAttentionTaskMap.get(str) != null || (linkedList = this.mUserAttentionRequestMap.get(str)) == null || linkedList.size() <= 0) {
            return;
        }
        AttentionAsyncTask attentionAsyncTask = new AttentionAsyncTask();
        this.mAttentionTaskMap.put(str, attentionAsyncTask);
        attentionAsyncTask.setPriority(2);
        attentionAsyncTask.setAlaAttentionData(linkedList.getFirst());
        attentionAsyncTask.execute(new Integer[0]);
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

    private long getLastShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            bx4 k = bx4.k();
            return k.m("ala_live_push_remind_showtime" + getUserId(), 0L);
        }
        return invokeV.longValue;
    }

    private String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                String id = currentAccountInfo.getID();
                return !TextUtils.isEmpty(id) ? id : "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    private void saveLastShowTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            bx4 k = bx4.k();
            k.x("ala_live_push_remind_showtime" + getUserId(), currentTimeMillis);
        }
    }

    public void cancelAllTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (AttentionAsyncTask attentionAsyncTask : this.mAttentionTaskMap.values()) {
                if (attentionAsyncTask != null) {
                    attentionAsyncTask.cancel();
                }
            }
            this.mAttentionTaskMap.clear();
        }
    }

    public void cancelTaskByToUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            AttentionAsyncTask attentionAsyncTask = this.mAttentionTaskMap.get(str);
            if (attentionAsyncTask != null) {
                attentionAsyncTask.cancel();
            }
            this.mAttentionTaskMap.remove(str);
        }
    }

    public boolean checkIsForbidden(UpdateAttentionMessage.a aVar, r9<?> r9Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, aVar, r9Var, z)) == null) {
            if (aVar != null && aVar.h != null && aVar.g != null && r9Var != null && r9Var.getPageActivity() != null) {
                int i = aVar.g.mServerErrorCode;
                if (!(i == 3250001 || i == 3250002 || i == 3250003 || i == 3250004)) {
                    return false;
                }
                if (aVar.i) {
                    return true;
                }
                JSONObject optJSONObject = aVar.h.optJSONObject("info");
                if (optJSONObject == null) {
                    return false;
                }
                String optString = optJSONObject.optString("block_content");
                String optString2 = optJSONObject.optString("block_dealurl");
                String optString3 = optJSONObject.optString("block_confirm");
                String optString4 = optJSONObject.optString("block_cancel");
                if (optString != null && optString2 != null && optString3 != null && optString4 != null) {
                    aVar.i = true;
                    au4 au4Var = new au4(r9Var.getPageActivity());
                    au4Var.setAutoNight(z);
                    au4Var.setMessage(optString);
                    au4Var.setPositiveButton(optString3, new au4.e(this, r9Var, optString2) { // from class: com.baidu.ala.view.AlaAttentionManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlaAttentionManager this$0;
                        public final /* synthetic */ String val$dealurl;
                        public final /* synthetic */ r9 val$pageContext;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9Var, optString2};
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
                            this.val$pageContext = r9Var;
                            this.val$dealurl = optString2;
                        }

                        @Override // com.baidu.tieba.au4.e
                        public void onClick(au4 au4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, au4Var2) == null) {
                                lo4.o(this.val$pageContext.getPageActivity(), this.val$dealurl);
                                au4Var2.dismiss();
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                            }
                        }
                    });
                    au4Var.setNegativeButton(optString4, new au4.e(this) { // from class: com.baidu.ala.view.AlaAttentionManager.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AlaAttentionManager this$0;

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

                        @Override // com.baidu.tieba.au4.e
                        public void onClick(au4 au4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, au4Var2) == null) {
                                au4Var2.dismiss();
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                            }
                        }
                    });
                    au4Var.create(r9Var).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    return true;
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public void removeRequestListAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (LinkedList<AlaAttentionData> linkedList : this.mUserAttentionRequestMap.values()) {
                if (linkedList != null) {
                    linkedList.clear();
                }
            }
            this.mUserAttentionRequestMap.clear();
        }
    }

    public void removeRequestListByUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mUserAttentionRequestMap.get(str).clear();
            this.mUserAttentionRequestMap.remove(str);
        }
    }

    public void removeRequestListFirstByUid(String str) {
        LinkedList<AlaAttentionData> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (linkedList = this.mUserAttentionRequestMap.get(str)) == null || linkedList.size() <= 0) {
            return;
        }
        try {
            linkedList.removeFirst();
        } catch (Exception unused) {
        }
    }

    public void showAttentionSucceedTip(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
        }
    }

    public void showAttentionSuccessTipAndLivePushDialog(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, tbPageContext, z) == null) {
            if (System.currentTimeMillis() - getLastShowTime() >= 86400000 && !x15.d().x()) {
                showLivePushRemindDialog(tbPageContext, z);
            } else if (z) {
                showAttentionSucceedTip(tbPageContext);
            }
        }
    }

    public void showLivePushRemindDialog(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, z) == null) || x15.d().x()) {
            return;
        }
        new AlaLivePushRemindDialog(tbPageContext).showDialog(z);
        saveLastShowTime();
    }

    public void updateAttention(String str, AlaAttentionData alaAttentionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, alaAttentionData) == null) || StringUtils.isNull(str) || alaAttentionData == null || alaAttentionData.getPortrait() == null) {
            return;
        }
        LinkedList<AlaAttentionData> linkedList = this.mUserAttentionRequestMap.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.mUserAttentionRequestMap.put(str, linkedList);
        }
        dealAttentionUpdateData(linkedList, alaAttentionData);
        executeAttentionTask(str);
    }
}
