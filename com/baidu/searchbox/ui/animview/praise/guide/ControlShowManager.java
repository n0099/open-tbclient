package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes13.dex */
public class ControlShowManager {
    public static final String DAY_TIME_FORMAT = "yyyy-MM-dd";
    public static final String KEY_CONTROL_DATA = "ControlData_KEY";
    public static final String KEY_CURRENT_DATA = "KEY_CURRENT_DATA";
    public static final String KEY_SHOW_CYCLE = "KEY_SHOW_TIME_CYCLE";
    public static final String KEY_SHOW_DAY = "KEY_SHOW_TIME_DAY";
    public static final String SP_FILE_NAME = "com.baidu.android.common.widget.praise";
    private static ControlShowManager mInstance;
    private ControlShowData mControlShowData;
    private CurrentShowData mCurrentShowData;
    private SharedPrefsWrapper mSpManager = new SharedPrefsWrapper("com.baidu.android.common.widget.praise");

    private ControlShowManager() {
    }

    public static synchronized ControlShowManager getInstance() {
        ControlShowManager controlShowManager;
        synchronized (ControlShowManager.class) {
            if (mInstance == null) {
                mInstance = new ControlShowManager();
            }
            controlShowManager = mInstance;
        }
        return controlShowManager;
    }

    public boolean saveControlData(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mControlShowData = new ControlShowData();
        this.mControlShowData.parseData(str);
        this.mSpManager.putString(KEY_CONTROL_DATA, str);
        return true;
    }

    public void setCycleTimeNoShow() {
        if (this.mControlShowData == null) {
            this.mControlShowData = new ControlShowData();
            this.mControlShowData.parseData(this.mSpManager.getString(KEY_CONTROL_DATA, ""));
        }
        if (this.mCurrentShowData == null) {
            this.mCurrentShowData = new CurrentShowData();
            this.mCurrentShowData.parseData(this.mSpManager.getString(KEY_CURRENT_DATA, ""));
        }
        this.mCurrentShowData.setCycleCurrentcount(Integer.MAX_VALUE);
        this.mSpManager.putString(KEY_CURRENT_DATA, this.mCurrentShowData.toJson());
    }

    public boolean canShow() {
        if (this.mControlShowData == null) {
            this.mControlShowData = new ControlShowData();
            this.mControlShowData.parseData(this.mSpManager.getString(KEY_CONTROL_DATA, ""));
        }
        if (this.mControlShowData.isOpen()) {
            if (this.mCurrentShowData == null) {
                this.mCurrentShowData = new CurrentShowData();
                this.mCurrentShowData.parseData(this.mSpManager.getString(KEY_CURRENT_DATA, ""));
            }
            String currentDay = getCurrentDay();
            if (!currentDay.equals(this.mSpManager.getString(KEY_SHOW_DAY, ""))) {
                this.mCurrentShowData.setDayCurrentCount(0);
                this.mSpManager.putString(KEY_SHOW_DAY, currentDay);
            }
            String string = this.mSpManager.getString(KEY_SHOW_CYCLE, "");
            if (TextUtils.isEmpty(string)) {
                this.mCurrentShowData.setCycleCurrentcount(0);
                this.mSpManager.putString(KEY_SHOW_CYCLE, currentDay);
            } else if (caculateDayGap(string) > this.mControlShowData.getCycleTime()) {
                this.mCurrentShowData.setCycleCurrentcount(0);
                this.mSpManager.putString(KEY_SHOW_CYCLE, currentDay);
            }
            this.mSpManager.putString(KEY_CURRENT_DATA, this.mCurrentShowData.toJson());
            if (this.mCurrentShowData.getSessionCurrentCount() >= this.mControlShowData.getSessionMaxCount() || this.mCurrentShowData.getDayCurrentCount() >= this.mControlShowData.getDayMaxCount() || this.mCurrentShowData.getCycleCurrentcount() >= this.mControlShowData.getCycleMaxcount()) {
                return false;
            }
            this.mCurrentShowData.setSessionCurrentCount(this.mCurrentShowData.getSessionCurrentCount() + 1);
            this.mCurrentShowData.setDayCurrentCount(this.mCurrentShowData.getDayCurrentCount() + 1);
            this.mCurrentShowData.setCycleCurrentcount(this.mCurrentShowData.getCycleCurrentcount() + 1);
            this.mSpManager.putString(KEY_CURRENT_DATA, this.mCurrentShowData.toJson());
            return true;
        }
        return false;
    }

    private String getCurrentDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private int caculateDayGap(String str) {
        try {
            return (int) ((new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getTime() - new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
