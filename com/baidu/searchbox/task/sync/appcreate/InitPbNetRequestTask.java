package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.d85;
import com.baidu.tieba.dl9;
import com.baidu.tieba.el9;
import com.baidu.tieba.fl9;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InitPbNetRequestTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_initPbNetRequest";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            Class.forName("com.baidu.tieba.pb.pb.main.PbActivityStatic");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (dl9.a().c() && d85.a().c == 1) {
            new fl9().i(d85.a().d);
        }
        if (dl9.a().c() && d85.a().c == 2) {
            try {
                String str = d85.a().d;
                el9.l(new String[]{new JSONObject(str.substring(str.indexOf("tbyunpushnotifybody=") + 20)).getString("jump_scheme")});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
