package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.nj9;
import com.baidu.tieba.oj9;
import com.baidu.tieba.pj9;
import com.baidu.tieba.u75;
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
        if (nj9.a().c() && u75.a().c == 1) {
            new pj9().i(u75.a().d);
        }
        if (nj9.a().c() && u75.a().c == 2) {
            try {
                String str = u75.a().d;
                oj9.l(new String[]{new JSONObject(str.substring(str.indexOf("tbyunpushnotifybody=") + 20)).getString("jump_scheme")});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
