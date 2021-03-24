package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.core.util.ListUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.ActiveCenter;
import tbclient.ActiveCenterMission;
import tbclient.ActiveCenterStatus;
import tbclient.ActiveConfig.DataRes;
/* loaded from: classes3.dex */
public class ActiveCenterData implements Serializable {
    public static final String PREF_KEY_ACTIVE_DIALOG_DAY_NUM = "pref_key_active_dialog_day_num";
    public int is_first_up;
    public boolean is_new_window;
    public ActiveCenterMissionData mission;
    public ArrayList<ActiveCenterStatusData> mission_status_list;
    public String win_desc;
    public int win_jump_time;
    public String win_title;

    /* loaded from: classes3.dex */
    public static class ActiveCenterMissionData implements Serializable {
        public int active_id;
        public int cleartime;
        public int cleartype;
        public String desc;
        public String final_reward_url;
        public String mission;
        public int mission_id;
        public int task_type;
        public int total_limit;

        public void parseProto(ActiveCenterMission activeCenterMission) {
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

    /* loaded from: classes3.dex */
    public static class ActiveCenterStatusData implements Serializable {
        public int day;
        public String desc;
        public boolean is_completed;
        public int is_today_mission;
        public String mission;

        public void parseProto(ActiveCenterStatus activeCenterStatus) {
            this.day = activeCenterStatus.day.intValue();
            this.is_completed = activeCenterStatus.is_completed.intValue() == 1;
            this.mission = activeCenterStatus.mission;
            this.is_today_mission = activeCenterStatus.is_today_mission.intValue();
            this.desc = activeCenterStatus.desc;
        }
    }

    public int getCurTaskType() {
        ActiveCenterMissionData activeCenterMissionData = this.mission;
        if (activeCenterMissionData == null) {
            return 0;
        }
        return activeCenterMissionData.task_type;
    }

    public ActiveCenterStatusData getTodayMissionStatus() {
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

    public void parseProto(ActiveCenter activeCenter) {
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
        this.is_new_window = activeCenter.is_new_window.intValue() == 1;
        this.is_first_up = activeCenter.is_first_up.intValue();
    }

    public void parseProto(DataRes dataRes) {
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
        this.is_new_window = dataRes.active_center.is_new_window.intValue() == 1;
        this.is_first_up = dataRes.active_center.is_first_up.intValue();
    }
}
