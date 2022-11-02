package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ActiveCenter;
import tbclient.ActiveCenterMission;
import tbclient.ActiveCenterStatus;
import tbclient.ActiveConfig.DataRes;
/* loaded from: classes3.dex */
public class ActiveCenterData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int is_first_up;
    public boolean is_new_window;
    public ActiveCenterMissionData mission;
    public ArrayList<ActiveCenterStatusData> mission_status_list;
    public String win_desc;
    public int win_jump_time;
    public String win_title;

    /* loaded from: classes3.dex */
    public static class ActiveCenterMissionData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int active_id;
        public int cleartime;
        public int cleartype;
        public String desc;
        public String final_reward_url;
        public String mission;
        public int mission_id;
        public int task_type;
        public int total_limit;

        public ActiveCenterMissionData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void parseProto(ActiveCenterMission activeCenterMission) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activeCenterMission) == null) {
                this.active_id = activeCenterMission.active_id.intValue();
                this.mission_id = activeCenterMission.mission_id.intValue();
                this.task_type = activeCenterMission.task_type.intValue();
                this.cleartype = activeCenterMission.cleartype.intValue();
                this.cleartime = activeCenterMission.cleartime.intValue();
                this.total_limit = activeCenterMission.total_limit.intValue();
                this.final_reward_url = activeCenterMission.final_reward_url;
                this.mission = activeCenterMission.mission;
                this.desc = activeCenterMission.desc;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ActiveCenterStatusData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int day;
        public String desc;
        public boolean is_completed;
        public int is_today_mission;
        public String mission;

        public ActiveCenterStatusData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void parseProto(ActiveCenterStatus activeCenterStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activeCenterStatus) == null) {
                this.day = activeCenterStatus.day.intValue();
                boolean z = true;
                if (activeCenterStatus.is_completed.intValue() != 1) {
                    z = false;
                }
                this.is_completed = z;
                this.mission = activeCenterStatus.mission;
                this.is_today_mission = activeCenterStatus.is_today_mission.intValue();
                this.desc = activeCenterStatus.desc;
            }
        }
    }

    public ActiveCenterData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getCurTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ActiveCenterMissionData activeCenterMissionData = this.mission;
            if (activeCenterMissionData == null) {
                return 0;
            }
            return activeCenterMissionData.task_type;
        }
        return invokeV.intValue;
    }

    public ActiveCenterStatusData getTodayMissionStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.mission_status_list)) {
                return null;
            }
            Iterator<ActiveCenterStatusData> it = this.mission_status_list.iterator();
            while (it.hasNext()) {
                ActiveCenterStatusData next = it.next();
                if (next.is_today_mission == 1) {
                    return next;
                }
            }
            return null;
        }
        return (ActiveCenterStatusData) invokeV.objValue;
    }

    public void parseProto(ActiveCenter activeCenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activeCenter) == null) {
            this.win_title = activeCenter.win_title;
            this.win_desc = activeCenter.win_desc;
            if (activeCenter.mission != null) {
                ActiveCenterMissionData activeCenterMissionData = new ActiveCenterMissionData();
                this.mission = activeCenterMissionData;
                activeCenterMissionData.parseProto(activeCenter.mission);
            }
            if (activeCenter.mission_status_list != null) {
                this.mission_status_list = new ArrayList<>();
                for (ActiveCenterStatus activeCenterStatus : activeCenter.mission_status_list) {
                    ActiveCenterStatusData activeCenterStatusData = new ActiveCenterStatusData();
                    activeCenterStatusData.parseProto(activeCenterStatus);
                    this.mission_status_list.add(activeCenterStatusData);
                }
            }
            this.win_jump_time = activeCenter.win_jump_time.intValue();
            boolean z = true;
            if (activeCenter.is_new_window.intValue() != 1) {
                z = false;
            }
            this.is_new_window = z;
            this.is_first_up = activeCenter.is_first_up.intValue();
        }
    }

    public void parseProto(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            ActiveCenter activeCenter = dataRes.active_center;
            this.win_title = activeCenter.win_title;
            this.win_desc = activeCenter.win_desc;
            if (activeCenter.mission != null) {
                ActiveCenterMissionData activeCenterMissionData = new ActiveCenterMissionData();
                this.mission = activeCenterMissionData;
                activeCenterMissionData.parseProto(dataRes.active_center.mission);
            }
            if (dataRes.active_center.mission_status_list != null) {
                this.mission_status_list = new ArrayList<>();
                for (ActiveCenterStatus activeCenterStatus : dataRes.active_center.mission_status_list) {
                    ActiveCenterStatusData activeCenterStatusData = new ActiveCenterStatusData();
                    activeCenterStatusData.parseProto(activeCenterStatus);
                    this.mission_status_list.add(activeCenterStatusData);
                }
            }
            this.win_jump_time = dataRes.active_center.win_jump_time.intValue();
            boolean z = true;
            if (dataRes.active_center.is_new_window.intValue() != 1) {
                z = false;
            }
            this.is_new_window = z;
            this.is_first_up = dataRes.active_center.is_first_up.intValue();
        }
    }
}
