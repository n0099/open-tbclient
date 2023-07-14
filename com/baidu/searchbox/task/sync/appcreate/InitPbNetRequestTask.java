package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.og9;
import com.baidu.tieba.pg9;
import com.baidu.tieba.qg9;
import com.baidu.tieba.u85;
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
        if (og9.a().c() && u85.a().c == 1) {
            new qg9().i(u85.a().d);
        }
        if (og9.a().c() && u85.a().c == 2) {
            try {
                String str = u85.a().d;
                pg9.l(new String[]{new JSONObject(str.substring(str.indexOf("tbyunpushnotifybody=") + 20)).getString("jump_scheme")});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
