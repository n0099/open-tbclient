package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.r.d;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class b<W extends d> implements ZeusPlugin {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected ZeusPlugin.Callback bwu;
    private W bwv;
    private boolean bww = false;
    private final List<ZeusPlugin.Command> bwx = new ArrayList();
    private d.a bwy = new d.a() { // from class: com.baidu.swan.apps.r.b.1
        @Override // com.baidu.swan.apps.r.d.a
        public void cF(boolean z) {
            synchronized (b.this) {
                if (b.DEBUG) {
                    Log.i("BaseInlineController", "组件初始化完成，开始flush挂起的指令=====");
                }
                b.this.Tt();
                b.this.bww = true;
                if (b.DEBUG) {
                    Log.i("BaseInlineController", "指令flush完成=========================");
                }
            }
        }
    };
    protected c<W> bwt = new c<>();

    public b(@NonNull W w) {
        this.bwv = w;
        if (DEBUG) {
            Log.i("BaseInlineController", "开始初始化组件");
        }
        this.bwv.a(this.bwy);
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void setCallback(ZeusPlugin.Callback callback) {
        this.bwu = callback;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        synchronized (this) {
            if (command != null) {
                if (this.bww) {
                    if (DEBUG) {
                        Log.v("BaseInlineController", "组件已初始化，直接尝试分发Command: + " + command.what);
                    }
                    this.bwt.b(command, this.bwv);
                } else {
                    ZeusPlugin.Command command2 = new ZeusPlugin.Command();
                    command2.what = command.what;
                    command2.arg1 = command.arg1;
                    command2.arg2 = command.arg2;
                    command2.arg3 = command.arg3;
                    command2.arg4 = command.arg4;
                    command2.arg5 = command.arg5;
                    command2.obj = command.obj;
                    this.bwx.add(command2);
                    if (DEBUG) {
                        Log.i("BaseInlineController", "组件未初始化，加入Pending队列： " + command2.what);
                    }
                    this.bwt.a(command);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (this.bwx.size() != 0) {
            Iterator<ZeusPlugin.Command> it = this.bwx.iterator();
            while (it.hasNext()) {
                ZeusPlugin.Command next = it.next();
                if (DEBUG) {
                    Log.i("BaseInlineController", "flush-尝试分发Command: + " + next.what);
                }
                this.bwt.b(next, this.bwv);
                it.remove();
            }
        }
    }
}
