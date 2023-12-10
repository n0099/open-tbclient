package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.ly9;
import com.baidu.tieba.q35;
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
        if (jy9.a().c() && q35.a().c == 1) {
            new ly9().i(q35.a().d);
        }
        if (jy9.a().c() && q35.a().c == 2) {
            try {
                String str = q35.a().d;
                ky9.l(new String[]{new JSONObject(str.substring(str.indexOf("tbyunpushnotifybody=") + 20)).getString("jump_scheme")});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
